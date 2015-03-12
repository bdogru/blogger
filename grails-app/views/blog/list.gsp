
<html>

<head></head>
<body>
	<g:if test="${flash.message}">
		<div class="message" role="status">
			${flash.message}
		</div>
	</g:if>
	<g:form action="list">
		Tag: <g:field type="text" value="${tag }" name="tag"
			placeholder="-Filter Tag-" />

		<button type="submit" class="btn">Filter</button>
	</g:form>
	<g:form action="list">
		Page: <g:select name="page" from="${1..pages}" value="${page}"
			noSelection="['1':'-Page-']"
			onchange="this.form.submit()" />

		<g:field type="hidden" value="${tag }" name="tag"/>
	</g:form>
	<div id="postList">
		<g:each in="${posts}" var="post">

			<h1>
				${post.title}
			</h1>
			<p class="lead">
				By <span class="text-info"> ${post.email}
				</span> on
				<g:formatDate format="dd/MM/yyyy @ HH:mm" date="${post.dateCreated}" />
			</p>

			${post.content}

			<hr />

		</g:each>
	</div>
</body>

</html>