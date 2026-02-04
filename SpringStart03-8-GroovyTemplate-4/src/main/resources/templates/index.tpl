layout 'layout.tpl',
    title: title,
    bodyContents: contents{
        p(msg)
        div(class:"alert alert-primary"){
            h6("alert")
            p("Message: $msg")
        }
    }
