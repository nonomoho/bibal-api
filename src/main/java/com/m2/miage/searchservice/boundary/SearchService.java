package com.m2.miage.searchservice.boundary;

import com.m2.miage.usagerService.entity.Usager;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SearchService {
    private final EntityManager em;

    @Autowired
    public SearchService(EntityManager em) {
        this.em = em;
    }

    public void initializeSearch() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public List usagerSearch(String query) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
                .forEntity(Usager.class).get();
        Query luceneQuery = queryBuilder.keyword().onFields("nom", "prenom", "adresse", "telephone")
                .matching(query).createQuery();
        javax.persistence.Query jpaQuery = fullTextEntityManager
                .createFullTextQuery(luceneQuery, Usager.class);
        return jpaQuery.getResultList();
    }
}
