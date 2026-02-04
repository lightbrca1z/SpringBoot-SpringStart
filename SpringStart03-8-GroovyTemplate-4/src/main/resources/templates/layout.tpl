yiledUnescaped '<!DOCTYPE html>'

html(lang:'ja'){
	head{
		meta(charset:"UTF-8")
		title(title)
		link(rel:"stylesheet", type:"text/css", href:"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css")
	}
	body(class:"container"){
	h1(class:"display-4", title)
    bodyContents()
    footer(class:"fixed-bottom p-2"){
        hr(class:"m-1")
        p(class:"text-center m-0 p-0",
        "copyright by T.Iwamoto 2026.")
    }
}
}
