package blagger

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.EmailValidator;

@grails.validation.Validateable
class Post {

    String title
    String email
    String content
	String tag = ""
    Date dateCreated
    Date lastUpdated

    static constraints = {
		title blank: false, minLength:3
		email email: true
		content blank:false
		
    }

    static mapping = {
        content type: 'text'
    }

	def beforeInsert() {
	   dateCreated = new Date()
	 }

	def beforeUp() {
	   lastUpdated = new Date()
	 }
	
	def validate() {
		def errorList = [];
		if(StringUtils.isBlank(title) || title.length()<3) {
			errorList.add("Title cannot be blank and it's length must be above 3.")
		}
		if(StringUtils.isBlank(content)) {
			errorList.add("The blag cannot be blank.")
		}
		if(StringUtils.isNotBlank(email) && !EmailValidator.getInstance().isValid(email)) {
			errorList.add("Email format is not valid.")
		}
		if(errorList.isEmpty()) {
			[status:true]
		} else {
			[status:false, errorList:errorList]
		}
	}
}
