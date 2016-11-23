<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class = "box">
    <div class="logo">
        <img src="/static/images/bookstore.png?11" />
    </div>
    <div class="search_form">
        <form method="POST" action="/search" class="form-wrapper cf">
            <input name="keyword" type="text"  placeholder="Search book here..." required/>
            <button type="submit">Search</button>
        </form>
    </div>

    <div class="search_results">

    </div>
</div>
