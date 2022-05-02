package com.ulstu.HomeBudget.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.ulstu.HomeBudget.Model.category_expense;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class category_expense_service {
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
    public category_expense add_category_expense(String category, int limits, int passibility_planning, int category_necessity) {
        if(!StringUtils.hasText(category) || limits < 0 || passibility_planning < 0 || category_necessity < 0){
            throw new IllegalArgumentException("category name/passibility_planning/category_necessity is null or empty");
        }
        final category_expense category_expense = new category_expense(category, limits, passibility_planning, category_necessity);
        em.persist(category_expense);
        return category_expense;
    }

    @Transactional(readOnly = true)
    public category_expense find_category_expense(Long id) {
        final category_expense category_expense = em.find(category_expense.class, id);
        if (category_expense == null) {
            throw new EntityNotFoundException(String.format("category_expense with id [%s] is not found", id));
        }
        return category_expense;
    }

    @Transactional(readOnly = true)
    public List<category_expense> find_All_category_expense() {
        return em.createQuery("select s from category_expense s", category_expense.class)
                .getResultList();
    }

    @Transactional
    public category_expense update_category_expense(Long id, String category, int limits, int passibility_planning, int category_necessity) {
        if(!StringUtils.hasText(category) || limits < 0 || passibility_planning < 0 || category_necessity < 0){
            throw new IllegalArgumentException("category name/passibility_planning/category_necessity is null or empty");
        }
        final category_expense current_category_expense = find_category_expense(id);
        current_category_expense.setCategory(category);
        current_category_expense.setLimits(limits);
        current_category_expense.setPassibility_planning(passibility_planning);
        current_category_expense.setCategory_necessity(category_necessity);
        return em.merge(current_category_expense);
    }

    @Transactional
    public category_expense delete_category_expense(Long id) {
        final category_expense current_category_expense = find_category_expense(id);
        em.remove(current_category_expense);
        return current_category_expense;
    }

    @Transactional
    public void delete_All_category_expenses() {
        em.createQuery("delete from category_expense").executeUpdate();
    }
}
