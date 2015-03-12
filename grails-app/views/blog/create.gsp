
<html>

<r:script>

    $('input[name=title]').focus();

</r:script>

<head></head>

<body>
	<g:if test="${flash.message}">
		<div class="message" role="status">
			${flash.message}
		</div>
	</g:if>
	<g:form controller="blog" action="createPost" class="form-horizontal">

		<fieldset>
			<legend>Blag about something new!</legend>

			<div class="control-group">
				<label class="control-label" for="title">Title</label>
				<div class="controls">
					<g:field name="title" value="${post?.title}" type="text" required=""
						placeholder="My first blag post..." class="input-block-level" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="title">Your email</label>
				<div class="controls">
					<g:field name="email" value="${post?.email}" type="email"
						placeholder="test@test.com" class="input-block-level" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="tag">Tag</label>
				<div class="tag">
					<g:field name="tag" value="${post?.tag}" type="text"
						placeholder="Tag for blag post" class="input-block-level" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="content">The blag</label>
				<div class="controls">
					<g:textArea name="content" value="${post?.content}" required=""
						placeholder="The blag..." class="input-block-level" rows="10" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Submit</button>
				</div>
			</div>

		</fieldset>

	</g:form>

</body>

</html>