<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Add new city</title>


<link href="http://seantheme.com/color-admin-v2.2/admin/html/assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet">
<link href="http://seantheme.com/color-admin-v2.2/admin/html/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="http://seantheme.com/color-admin-v2.2/admin/html/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="http://seantheme.com/color-admin-v2.2/admin/html/assets/css/animate.min.css" rel="stylesheet">
<link href="http://seantheme.com/color-admin-v2.2/admin/html/assets/css/style.min.css" rel="stylesheet">
<link href="http://seantheme.com/color-admin-v2.2/admin/html/assets/css/style-responsive.min.css" rel="stylesheet">
<link href="http://seantheme.com/color-admin-v2.2/admin/html/assets/css/theme/default.css" rel="stylesheet">
</head>
<body>
	<div id="content" class="content">
			<div class="row">
			    <div class="col-md-6 ui-sortable">
			        <div class="panel panel-inverse" >
                        <div class="panel-heading">
                            <h4 class="panel-title">Add city</h4>
                        </div>
                        <div class="panel-body">
                            <form method="POST" class="form-horizontal" action='CityController' name="frmAddCity">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">City :</label>
                                    <div class="col-md-9">
                                        <input type="text" name="cityName"  class="form-control" value="<c:out value="${city.cityName}" />" /> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Country :</label>
                                    <div class="col-md-9">
                                        <input type="text" name="country"  class="form-control" value="<c:out value="${city.country}" />" /> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Attractions :</label>
                                    <div class="col-md-9">
                                        <input type="text" name="attractions" placeholder="Seperated by ," class="form-control" value="<c:out value="${city.attractions}"  />" /> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-9">
                                        <input type="submit" class="btn btn-sm btn-success" value="Submit" /> 
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
			</div>
	</div>
</body>
</html>