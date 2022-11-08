function send_request() {
    let data = $('#form').serializeArray().reduce(function(obj, item) {
        obj[item.name] = item.value;
        return obj;
    }, {});
    let settings = {
        "url": "/api/contact",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify(data),
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}