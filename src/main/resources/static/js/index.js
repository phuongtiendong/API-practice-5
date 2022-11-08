function delete_all() {
    let settings = {
        "url": "/api/contact",
        "method": "DELETE",
        "timeout": 0,
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}

function get_by_id() {
    window.location.href = "/api/contact/" + document.getElementById("id_get").value;
}

function delete_by_id() {
    let settings = {
        "url": "/api/contact/" + document.getElementById("id_del").value,
        "method": "DELETE",
        "timeout": 0,
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}