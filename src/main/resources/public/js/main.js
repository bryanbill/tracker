function delRoute(route) {
    fetch(route, {
        method: 'DELETE',
    }).then(response => {
        console.log(response);
        window.location.reload();
    }).catch(error => {
        console.log(error);
    });
}