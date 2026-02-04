yiledUnescaped '<!DOCTYPE html>'

html(lang:'ja'){
	head{
		meta(charset:"UTF-8")
		title(title)
		link(rel:"stylesheet", type:"text/css", href:"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css")
	}
	body(class:"container"){
	h1(class:"display-4", title)
    p(msg)
    ul(class:"list-group"){
        data.each{
            li(class:"list-group-item", it)
        }
    }
}
}