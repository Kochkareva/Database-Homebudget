package com.ulstu.HomeBudget.Service;

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
public class expense_service {
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
    public expense add_expense(Date date_operation, int summa) {
        if(date_operation!=null || summa < 0){
            throw new IllegalArgumentException("date_operation/summa is null or empty");
        }
        final expense expense = new expense(date_operation, summa);
        em.persist(expense);
        return expense;
    }

    @Transactional(readOnly = true)
    public expense find_expense(Long id) {
        final expense expense = em.find(expense.class, id);
        if (expense == null) {
            throw new EntityNotFoundException(String.format("expense with id [%s] is not found", id));
        }
        return expense;
    }

    @Transactional(readOnly = true)
    public List<expense> find_All_expense() {
        return em.createQuery("select s from expense s", expense.class)
                .getResultList();
    }

    @Transactional
    public expense update_expense(Long id, Date date_operation, int summa) {
        if(date_operation == null || summa < 0){
            throw new IllegalArgumentException("date_operation/summa is null or empty");
        }
        final expense current_expense = find_expense(id);
        current_expense.setDate_operation(date_operation);
        current_expense.setSumma(summa);
        return em.merge(current_expense);
    }

    @Transactional
    public expense delete_expense(Long id) {
        final expense current_expense = find_expense(id);
        em.remove(current_expense);
        return current_expense;
    }

    @Transactional
    public void delete_All_expenses() {
        em.createQuery("delete from expense").executeUpdate();
    }
}
