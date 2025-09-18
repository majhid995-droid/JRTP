<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Citizen Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">
        <h4 class="text-center mb-4 text-primary">Report Generation</h4>

        <!-- Search Form -->
        <form:form method="post" action="searchInfo" modelAttribute="search">
            <div class="row g-3">
                <!-- Plan Name -->
                <div class="col-12 col-md-4">
                    <label class="form-label">Plan Name</label>
                    <form:select path="planName" Class="form-select">
                        <form:option value="">-- Select --</form:option>
                        <form:options items="${plan}"/>
                    </form:select>
                </div>

                <!-- Plan Status -->
                <div class="col-12 col-md-4">
                    <label class="form-label">Plan Status</label>
                    <form:select path="planStatus" Class="form-select">
                        <form:option value="">-- Select --</form:option>
                        <form:options items="${status}" /> 
                    </form:select>
                </div>

                <!-- Gender -->
                <div class="col-12 col-md-4">
                    <label class="form-label">Gender</label>
                    <form:select path="gender" cssClass="form-select">
                        <form:option value="">-- Select --</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                    </form:select>
                </div>

                <!-- Start Date -->
                <div class="col-12 col-md-4">
                    <label class="form-label">Start Date</label>
                    <form:input path="startDate" type="date" Class="form-control"/>
                </div>

                <!-- End Date -->
                <div class="col-12 col-md-4">
                    <label class="form-label">End Date</label>
                    <form:input path="endDate" type="date" Class="form-control"/>
                </div>

                <!-- Search Button -->
                <div class="col-12 col-md-4 d-flex align-items-end">
                    <button type="submit" class="btn btn-primary w-100">
                        <i class="bi bi-search"></i> Search
                    </button>
                </div>
            </div>
        </form:form>

        <hr class="my-4">

        <!-- Results placeholder -->
        

        <hr class="my-4">

        <!-- Export Links -->
        <div class="d-flex justify-content-center gap-3">
            <span class="fw-bold">Export:</span>
            <a href="#" class="link-primary fw-semibold">Excel</a>
            <a href="#" class="link-danger fw-semibold">PDF</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
