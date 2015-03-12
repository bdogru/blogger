package blagger

import org.apache.commons.lang.StringUtils;

class BlogController {

    static defaultAction = "list"
	
    def list() {
		params.max = Math.min(params.max ? params.int('max') : 5, 100)
		params.page = Math.max(params.page ? params.int('page') : 1, 1)
		if(params.tag == null) {
			params.tag = ""
		} else {
			params.tag = params.tag.trim()
		}
		println params
		Integer page = params.page
		Integer offset = 0
		if(page != null && page > 0) {
			offset = (page-1) * params.max
		}
		println offset + " " + params.tag
		def liste = Post.createCriteria().list(max: params.max, offset: offset) {
			if(StringUtils.isNotBlank(params.tag)) {
				like("tag", params.tag+"%")
			}
			order("id","desc")
		}
		def totalCount = liste.totalCount
		Integer pages = ((totalCount-1)/params.max)+1
		if (pages < 1) {
			pages = 1
		}
//        [posts: Post.list().sort { lhs, rhs -> rhs.id <=> lhs.id }]
		println liste
		println pages
		println params.page
		println params.tag
        [posts: liste, pages: pages, page:params.page, tag:params.tag]
    }

    def create(params) {
        [post: new Post(params)]
    }

    def createPost() {

        def aPost = new Post(params)
		
		def validation = aPost.validate();
		if(!validation.status) {
			flash.message = validation.errorList
            redirect(action: "create", params: [post: aPost])
            return
		}
        if (!aPost.save(flush: true)) {
			flash.message = aPost.errors
            redirect(action: "create", params: [post: aPost])
            return
        }

        redirect(action: 'list')
    }
}
