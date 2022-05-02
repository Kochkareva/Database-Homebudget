package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Model.revenue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.ulstu.HomeBudget.Model.expense;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service
public class revenue_service {
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
     * Date date_operation;
     *     int summa;
     */
    @Transactional
    public revenue add_revenue(Date date_operation, int summa) {
        if(date_operation!=null || summa < 0){
            throw new IllegalArgumentException("date_operation/summa is null or empty");
        }
        final revenue revenue = new revenue(date_operation, summa);
        em.persist(revenue);
        return revenue;
    }

    @Transactional(readOnly = true)
    public revenue find_revenue(Long id) {
        final revenue revenue = em.find(revenue.class, id);
        if (revenue == null) {
            throw new EntityNotFoundException(String.format("revenue with id [%s] is not found", id));
        }
        return revenue;
    }

    @Transactional(readOnly = true)
    public List<revenue> find_All_revenue() {
        return em.createQuery("select s from revenue s", revenue.class)
                .getResultList();
    }

    @Transactional
    public revenue update_revenue(Long id, Date date_operation, int summa) {
        if(date_operation == null || summa < 0){
            throw new IllegalArgumentException("date_operation/summa is null or empty");
        }
        final revenue current_revenue = find_revenue(id);
        current_revenue.setDate_operation(date_operation);
        current_revenue.setSumma(summa);
        return em.merge(current_revenue);
    }

    @Transactional
    public revenue delete_revenue(Long id) {
        final revenue current_revenue = find_revenue(id);
        em.remove(current_revenue);
        return current_revenue;
    }

    @Transactional
    public void delete_All_revenues() {
        em.createQuery("delete from revenue").executeUpdate();
    }
}
