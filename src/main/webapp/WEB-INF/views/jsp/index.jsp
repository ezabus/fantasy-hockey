<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>FantasyStat</title>
	<meta charset="utf-8">
	<spring:url value="/resources/core/css/hello.css" var="coreCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/core/css/jquery.datetimepicker.css" var="datetimepickerCss" />
	<spring:url value="/resources/core/css/bootstrap-switch.min.css" var="switchCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
	<link href="${datetimepickerCss}" rel="stylesheet" />
	<link href="${switchCss}" rel="stylesheet" />
</head>
<body>
<div class="container-fluid" >
	<div class="navbar navbar-inverse navbar-static-top" role="navigation">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" rel="home" href="/" title="FantasyStat">FantasyStat</a>
		</div>

		<div class="collapse navbar-collapse navbar-ex1-collapse">

			<ul class="nav navbar-nav">
				<li><a href="/khl" style="color:white">КХЛ</a></li>
				<li><a href="/nhl">НХЛ</a></li>
				<li><a href="http://www.sports.ru/tribuna/blogs/fantasypro/" title="Следите за новостями проекта" >Блог</a></li>
				<li><a href="http://www.sports.ru/profile/126606132/" title="Добавляйтесь в друзья, задавайте вопросы">Автор</a></li>
			</ul>

			<div class="col-md-3 pull-right">
				<div class="navbar-form" role="search">
					<div class="input-group date">
						<input type="text" id="datetimepicker" class="form-control">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-6" id="playerCard">
		<div class="input-group" id="teamlink">
			<input type="text" class="form-control" placeholder="Ссылка на команду" name="srch-term" id="srch-term">
			<div class="input-group-btn" id="teamSumbit">
				<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-ok"></i></button>
			</div>
		</div>
		<div class="" id="userName">
		</div>
		<div id="teamID">
		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a href="#commonStat" data-toggle="tab">Статистика</a></li>
			<li><a href="#achivs" data-toggle="tab">Достижения</a></li>
			<li><a href="#hist" data-toggle="tab">История</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="commonStat">
				<div class="row"  id="posInf">
					<div class="col-xs-4">
						День
					</div>
					<div class="col-xs-4">
						Неделя
					</div>
					<div class="col-xs-4">
						Сезон
					</div>
				</div>
				<div class="row" id="rank">
					<div class="col-xs-4" id="dailyRank">
						-
					</div>
					<div class="col-xs-4" id="weeklyRank">
						-
					</div>
					<div class="col-xs-4" id="overalRank">
						-
					</div>
				</div>
				<div id="rankLabel" class="commonStatLabel">место</div>
				<hr>
				<div class="row" id="points">
					<div class="col-xs-4" id="dailyPoints">
						-
					</div>
					<div class="col-xs-4" id="weeklyPoints">
						-
					</div>
					<div class="col-xs-4" id="overalPoints">
						-
					</div>
				</div>
				<div id="pointsLabel" class="commonStatLabel">очки</div>
			</div>
			<div class="tab-pane" id="achivs">
				<div class="row">
					<select class="form-control" id="achivSel">
						<option selected disabled>Выберите рейтинг</option>
						<option val="1">Общий зачёт</option>
						<option val="2">Недельный зачёт</option>
						<option val="3">Дневной зачёт</option>
					</select>
					<table class="table table-striped table-hover" id="achivTable">
						<tr><td>Лидер</td><td>Топ 10</td><td>Топ 100</td><td>Топ 500</td></tr>
						<tr><td>-</td><td>-</td><td>-</td><td>-</td></tr>
					</table>
				</div>
			</div>
			<div class="tab-pane" id="hist">
				<div class="panel panel-default">
					<div class="panel-heading">
						<button type="button" class="btn btn-default btn-xs spoiler-trigger" data-toggle="collapse" id="dayHistButton">
							Дни
						</button>
					</div>
					<div class="panel-collapse collapse out">
							<select class="form-control" id="monthSel">
								<option value="9">Сентябрь</option>
								<option value="10">Октябрь</option>
							</select>

						<table class="table table-striped table-hover" id="histTable">
							<tr><td>День</td><td>Очки</td><td>Место</td><td>ОЗ</td></tr>

						</table>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<button type="button" class="btn btn-default btn-xs spoiler-trigger" data-toggle="collapse" id="weekHistButton">
							Недели
						</button>
					</div>
					<div class="panel-collapse collapse out">
						<table class="table table-striped table-hover" id="histTableWeek">
							<tr><td>День</td><td>Очки</td><td>Место</td><td>ОЗ</td></tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div id="squadLabel" class="commonStatLabel"></div>
		<!--div id="squad">
			<div class="commonStatLabel">нападение</div>
			<table class="table" id="forwards-table">
				<tr><th>Имя</th><th>Команда</th><th>Очки</th><th>Стоимость</th></tr>
			</table>
			<div class="commonStatLabel">защита</div>
			<table class="table" id="deffs-table">
			</table>
			<div class="commonStatLabel">вратари</div>
			<table class="table" id="goalkeepers-table">
			</table>
		</div-->
		<div class="panel panel-default">
			<div class="panel-heading">
				<button type="button" class="btn btn-default btn-xs spoiler-trigger" data-toggle="collapse">Cостав</button>
				</div>
				<div class="panel-collapse collapse in">
				<div id="squad">
					<table class="table" id="squad-table">
						<tr><th>Имя</th><th>Команда</th><th>Очки</th><th>$</th></tr>
						<tr id="forwardsTr" class="squadLableRow"><th colspan="4">Нападение</th></tr>
						<tr id="deffsTr" class="squadLableRow"><th colspan="4" >Защита</th></tr>
						<tr id="gksTr" class="squadLableRow"><th colspan="4" >Вратари</th></tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="row" id="tableContainer">
			<div class="col-sm-6">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#day" data-toggle="tab">День</a></li>
				<li><a href="#week" data-toggle="tab">Неделя</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="day">
					<table class="table table-striped table-hover" id="day-table">
						<tr><th>#</th><th>Пользователь</th><th>Очки</th><th>ОЗ*</th></tr>
					</table>
				</div>
				<div class="tab-pane" id="week">
					<table class="table table-striped table-hover" id="week-table">
						<tr><th>#</th><th>Пользователь</th><th>Очки</th><th>ОЗ*</th></tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/achivs.js" var="achivsJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/jquery-2.1.4.min.js" var="jquery" />
<spring:url value="/resources/core/js/jquery.datetimepicker.js" var="datetimepicker" />
<spring:url value="/resources/core/js/bootstrap-switch.min.js" var="switch" />
<spring:url value="/resources/core/js/top.js" var="top" />
<spring:url value="/resources/core/js/squad.js" var="squad" />
<spring:url value="/resources/core/js/history.js" var="history" />

<script src="${jquery}"></script>
<script src="${coreJs}"></script>
<script src="${achivsJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${datetimepicker}"></script>
<script src="${switch}"></script>
<script src="${top}"></script>
<script src="${squad}"></script>
<script src="${history}"></script>
<script type="text/javascript">
</script>

</body>
</html>
