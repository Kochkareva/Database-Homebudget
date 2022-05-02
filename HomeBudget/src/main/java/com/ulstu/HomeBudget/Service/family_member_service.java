package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Model.family_member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.ulstu.HomeBudget.Model.category_expense;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class family_member_service {
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
     *     String surname;
     *     String middle_name;
     *     String name;
     *     int age;
     *     String email;
     */
    @Transactional
    public family_member add_family_member(String surname, String middle_name, String name, int age, String email) {
        if(!StringUtils.hasText(surname) || !StringUtils.hasText(middle_name)  || !StringUtils.hasText(name)  || age <= 0
        || !StringUtils.hasText(email) ){
            throw new IllegalArgumentException("surname/middle_name/name/age/email is null or empty");
        }
        final family_member family_member = new family_member(surname, middle_name, name, age, email);
        em.persist(family_member);
        return family_member;
    }

    @Transactional(readOnly = true)
    public family_member find_family_member(Long id) {
        final family_member family_member = em.find(family_member.class, id);
        if (family_member == null) {
            throw new EntityNotFoundException(String.format("family_member with id [%s] is not found", id));
        }
        return family_member;
    }

    @Transactional(readOnly = true)
    public List<family_member> find_All_family_member() {
        return em.createQuery("select s from family_member s", family_member.class)
                .getResultList();
    }

    @Transactional
    public family_member update_family_member(Long id, String surname, String middle_name, String name, int age, String email) {
        if(!StringUtils.hasText(surname) || !StringUtils.hasText(middle_name)  || !StringUtils.hasText(name)  || age <= 0
                || !StringUtils.hasText(email) ){
            throw new IllegalArgumentException("surname/middle_name/name/age/email is null or empty");
        }
        final family_member current_family_member = find_family_member(id);
        current_family_member.setSurname(surname);
        current_family_member.setMiddle_name(middle_name);
        current_family_member.setName(name);
        current_family_member.setAge(age);
        current_family_member.setEmail(email);
        return em.merge(current_family_member);
    }

    @Transactional
    public family_member delete_family_member(Long id) {
        final family_member current_family_member = find_family_member(id);
        em.remove(current_family_member);
        return current_family_member;
    }

    @Transactional
    public void delete_All_family_member() {
        em.createQuery("delete from family_member").executeUpdate();
    }
}
