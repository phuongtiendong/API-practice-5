function send_request() {
    let data = $('#form').serializeArray().reduce(function(obj, item) {
        obj[item.name] = item.value;
        return obj;
    }, {});
    data.id = Number(data.id);
    let settings = {
        "url": "/api/contact" + document.getElementById("id").value,
        "type": "PUT",
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