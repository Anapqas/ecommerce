package com.avanade.avanade.repository;

import com.avanade.avanade.dto.CategoriaDTO;
import com.avanade.avanade.entity.Category;
import com.avanade.avanade.entity.QCategory;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaFilterRepository extends QuerydslRepositorySupport {
  @PersistenceContext
  private EntityManager em;
  public CategoriaFilterRepository() {
    super(Category.class);
  }

  public List<Category> filter(CategoriaDTO dto) {
    QCategory category = QCategory.category;
    List<Predicate> predicates = new ArrayList<>();
    if (dto.nome() != null) {
       predicates.add(category.nome.like("%" + dto.nome() + "%"));
    }

    if (dto.descricao() != null) {
      predicates.add(category.descricao.like("%" + dto.descricao() + "%"));
    }

    return new JPAQueryFactory(em)
        .selectFrom(category)
        .where(predicates.toArray(new Predicate[0]))
        .fetch();
  }
}
