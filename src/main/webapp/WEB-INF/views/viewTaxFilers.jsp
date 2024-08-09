<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cestar.beans.TaxFiler" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tax Filers</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Tax Filers</h1>

    <table class="table mt-3">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Contact</th>
                <th>Annual Income</th>
                <th>Expenses</th>
                <th>Tax Year</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Assuming 'taxFilers' is a List<TaxFiler> passed from the controller
                List<com.cestar.beans.TaxFiler> taxFilers = (List<com.cestar.beans.TaxFiler>) request.getAttribute("taxFilers");
                if (taxFilers != null) {
                    for (com.cestar.beans.TaxFiler filer : taxFilers) {
            %>
                <tr>
                    <td><%= filer.getFilerID() %></td>

					<!--  Update form -->
                    <form action="taxFiler/update" method="post" style="display:inline;">
                    <input type="hidden" name="filerID" value="<%= filer.getFilerID() %>" />
	                    <td>
	                    	
	                        <input type="text" name="name" value="<%= filer.getName() %>" class="form-control" required />
						</td>
						
						<td>
	                    	<input type="text" name="contact" value="<%= filer.getContact() %>" class="form-control" required />
	                    </td>
	                    
	                    <td>
							<input type="number" name="annualIncome" step="0.01" value="<%= filer.getAnnualIncome() %>" class="form-control" required />
						</td>
	                            
	                    <td>
							<input type="number" name="expenses" step="0.01" value="<%= filer.getExpenses() %>" class="form-control" required />
						</td>
						
	                    <td>
	                    	<input type="number" name="taxYear" value="<%= filer.getTaxYear() %>" class="form-control"required />
	                    </td>
	                    
	                    <td>
	                    	<input type="submit" value="Update" class="btn btn-warning btn-sm" />
	                    </td>
                        
					</form>
					
       				<!-- Delete form -->
                    <form action="taxFiler/delete" method="post" style="display:inline;">
						<td>
                            <input type="hidden" name="filerID" value="<%= filer.getFilerID() %>" />
                            <input type="submit" value="Delete" class="btn btn-danger btn-sm" />
						</td>
                    </form>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="7">No Tax Filers found.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <h2 class="mt-5">Add New Tax Filer</h2>
    <form action="taxFiler/add" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="contact">Contact</label>
            <input type="text" id="contact" name="contact" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="annualIncome">Annual Income</label>
            <input type="number" id="annualIncome" name="annualIncome" step="0.01" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="expenses">Expenses</label>
            <input type="number" id="expenses" name="expenses" step="0.01" class="form-control" required />
        </div>
        <div class="form-group">
            <label for="taxYear">Tax Year</label>
            <input type="number" id="taxYear" name="taxYear" class="form-control" required />
        </div>
        <button type="submit" class="btn btn-primary">Add Filer</button>
    </form>
</div>
</body>
</html>
