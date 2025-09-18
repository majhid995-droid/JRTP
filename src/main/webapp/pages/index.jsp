<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Citizen Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		table thead th {
					  position: sticky;
					  top: 0;
					  z-index: 2;     /* keeps header above rows */
					  background: #f8f9fa; /* or use Bootstrap's table-light */
					}
	</style>
</head>
<body class="bg-light">

<div class="container">
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
                    <button type="submit" class="btn btn-primary w-100 me-4">Search</button>
                	<a href="./" class="btn btn-secondary w-100">Reset</a>
                </div>
            </div>
        </form:form>

        <hr class="my-4">
        	<div class="table-responsive" style="max-height: 300px; overflow-y: auto;">
        		<table class="table table-hover table-striped-columns">
        		<thead class="table-light">
        			<tr class="text-center">
        			<th>S.No</th>
        			<th>Name</th>
        			<th>Gender</th>
        			<th>Plan</th>
        			<th>Status</th>
        			<th>Start Date</th>
        			<th>End Date</th>
        			<th>Benefit Amount</th>
        			<th>Denial Reason</th>
        			<th>Termination Date</th>
        			<th>Termination Reason</th>
        		</tr>
        		</thead>
        		<tbody>
        			<c:forEach items="${cList}" var="plan" varStatus="index">
        			<tr class="text-center">
        				<td>${index.count}</td>
        				<td>${plan.citizen_Name}</td>
        				<td>${plan.gender}</td>
        				<td>${plan.plan_Name}</td>
        				<td>${plan.plan_Status}</td>
        				<td>${plan.plane_Start_Date}</td>
        				<td>${plan.plan_End_Date}</td>
        				<td>${plan.benefit_Amount}</td>
        				<td>${plan.denial_Resason}</td>
        				<td>${plan.termination_Date}</td>
        				<td>${plan.termination_Reason}</td>
        			</tr>
        		</c:forEach>
        		<c:if test="${empty cList}">
        			<tr class="text-center table-warning">
        				<td colspan="11" class=" text-danger ">No Record Found</td>
        			</tr>
        		</c:if>
        		</tbody>
        	</table>
        	</div>
                

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
