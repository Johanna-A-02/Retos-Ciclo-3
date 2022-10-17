//FUNCION PARA CARGAR LOS DATOS DE LA TABLA APENAS SE INICIA 
window.onload = function () {
    clientGetClientes();
}

//FUNCION PARA LLENAR LA TABLA
function clientGetClientes() {
    $.ajax({
        url: "http://localhost:8080/api/Client/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                tableBody += "<tr>";
                tableBody += "<td>" + respuesta[i].idClient + "</td>";
                tableBody += "<td>" + respuesta[i].name + "</td>";
                tableBody += "<td>" + respuesta[i].email + "</td>";
                tableBody += "<td>" + respuesta[i].age + "</td>";
                /* tableBody += "<td>" + respuesta[i].password + "</td>"; */
                tableBody += "<td> <button class='btn btn-danger mb-2' onclick='clientDeleteClient(" + respuesta[i].idClient + ")'><b>Eliminar Cliente</b></button>"
                    + " <button class='btn btn-info mb-2' onclick='verDetalle(\"" + respuesta[i].idClient + "\",\"" + respuesta[i].name + "\",\"" + respuesta[i].email + "\",\"" + respuesta[i].age + "\",\"" + respuesta[i].password + "\")'><b>Ver Detalle </b></button> </td>";
                tableBody += "</tr>";
            }
            $("#t-body-client").append(tableBody);
        }
    });
}

//FUNCION PARA CREAR
function clientPostClient() {
    let myData = {
        idClient: $("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $("#password").val()
    }

    let errorMessage = "";

    if (!myData.idClient) {
        errorMessage += " •ID "
    }
    if (!myData.name || myData.name.trim().length === 0) {
        errorMessage += " •Nombre "
    }
    if (!myData.email || myData.email.trim().length === 0) {
        errorMessage += " •Email "
    }
    if (!myData.age) {
        errorMessage += " •Edad "
    }
    if (!myData.password || myData.password.trim().length === 0) {
        errorMessage += " •Contraseña "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Client/save",
        type: "POST",
        dataType: 'JSON',
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Cliente creado correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Cliente creado correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al crear Cliente!");
            }
        }
    });
}

//FUNCION PARA ACTUALIZAR
function clientPutClient() {

    let myData = {
        idClient: $("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $("#password").val()
    }

    let errorMessage = "";

    if (!myData.idClient) {
        errorMessage += " •ID "
    }
    if (!myData.name || myData.name.trim().length === 0) {
        errorMessage += " •Nombre "
    }
    if (!myData.email || myData.email.trim().length === 0) {
        errorMessage += " •Email "
    }
    if (!myData.age) {
        errorMessage += " •Edad "
    }
    if (!myData.password || myData.password.trim().length === 0) {
        errorMessage += " •Contraseña "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Client/update",
        type: "PUT",
        /* dataType: 'JSON', */
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Cliente actualizado correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Cliente actualizado correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al actualizar Cliente!");
            }
        }
    });
}

//FUNCION PARA ELIMINAR
function clientDeleteClient(itemId) {
    let urlDelete = "http://localhost:8080/api/Client/" + itemId;

    $.ajax({
        url: urlDelete,
        type: "DELETE",
        contentType: 'application/json',
        success: function (respuesta) {
            console.log(respuesta);
            alert("Cliente eliminado correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            console.log(errores);
            alert("Error al eliminar Cliente!");
        }
    });
}

//Llenar campos a actualizar

//FUNCION PARA VER DETALLE
function verDetalle(id, name, email, age, password) {

    $("#id").val(id);
    $("#name").val(name);
    $("#email").val(email);
    $("#age").val(age);
    $("#password").val(password);

    $("#id").prop('disabled', true);
    $("#email").prop('disabled', true);

}

//FUNCION PARA LIMPIAR CAMPOS
function limpiarCampos() {

    $("#id").val('');
    $("#name").val('');
    $("#email").val('');
    $("#age").val('');
    $("#password").val('');

    $("#id").prop('disabled', false);
    $("#email").prop('disabled', false);

}