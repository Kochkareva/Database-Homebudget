package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Model.source_revenue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.ulstu.HomeBudget.Model.category_expense;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class source_revenue_service {
    @PersistenceContext
    private EntityManager em;

    /**
     * hasText(CharSequence str)
     Проверьте CharSequence, содержит ли данный текст фактический текст.
     * final - предотвращает наследование.
     * em - Entity Manager
     * При использовании merge вместо persist: Hibernate выполнит SELECT выражение для того чтобы убедиться
     что в БД не существует записи с таким же идентификатором.
     Для новых сущностей, всегда нужно использовать persist, а для detached сущностей нужно вызывать merge
     * */
    /***
     * String category;
     *     int limits;
     *     int passibility_planning;
     *     int category_necessity;
     */
    @Transactional
    public source_revenue add_source_revenue(String name_source, String type_source, String regularity, String nature_receipt, String real_form) {
        if (!StringUtils.hasText(name_source) || !StringUtils.hasText(type_source) || !StringUtils.hasText(regularity) ||
                !StringUtils.hasText(nature_receipt) || !StringUtils.hasText(real_form)) {
            throw new IllegalArgumentException("name_source/type_source/regularity/nature_receipt/real_form is null or empty");
        }
        final source_revenue source_revenue = new source_revenue(name_source, type_source, regularity, nature_receipt, real_form);
        em.persist(source_revenue);
        return source_revenue;
    }

    @Transactional(readOnly = true)
    public source_revenue find_source_revenue(Long id) {
        final source_revenue source_revenue = em.find(source_revenue.class, id);
        if (source_revenue == null) {
            throw new EntityNotFoundException(String.format("source_revenue with id [%s] is not found", id));
        }
        return source_revenue;
    }

    @Transactional(readOnly = true)
    public List<source_revenue> find_All_source_revenue() {
        return em.createQuery("select s from source_revenue s", source_revenue.class)
                .getResultList();
    }

    @Transactional
    public source_revenue update_source_revenue(Long id, String name_source, String type_source, String regularity,
                                                String nature_receipt, String real_form) {
        if (!StringUtils.hasText(name_source) || !StringUtils.hasText(type_source) || !StringUtils.hasText(regularity) ||
                !StringUtils.hasText(nature_receipt) || !StringUtils.hasText(real_form)) {
            throw new IllegalArgumentException("name_source/type_source/regularity/nature_receipt/real_form is null or empty");
        }
        final source_revenue current_source_revenue = find_source_revenue(id);
        current_source_revenue.setName_source(name_source);
        current_source_revenue.setType_source(type_source);
        current_source_revenue.setRegularity(regularity);
        current_source_revenue.setNature_receipt(nature_receipt);
        current_source_revenue.setReal_form(real_form);
        return em.merge(current_source_revenue);
    }

    @Transactional
    public source_revenue delete_source_revenue(Long id) {
        final source_revenue current_source_revenue = find_source_revenue(id);
        em.remove(current_source_revenue);
        return current_source_revenue;
    }

    @Transactional
    public void delete_All_source_revenues() {
        em.createQuery("delete from source_revenue").executeUpdate();
    }
}
