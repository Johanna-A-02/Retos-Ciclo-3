//FUNCION PARA CARGAR LOS DATOS DE LA TABLA APENAS SE INICIA 
window.onload = function () {
    adminUserGetAdminUser();
}

//FUNCION PARA LLENAR LA TABLA
function adminUserGetAdminUser() {
    $.ajax({
        url: "http://localhost:8080/api/AdminUser/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                tableBody += "<tr>";
                tableBody += "<td style='text-align: center'>" + (respuesta[i].idAdminUser||"") + "</td>";
                tableBody += "<td style='text-align: center'>" + (respuesta[i].name||"") + "</td>";
                tableBody += "<td style='text-align: center'>" + (respuesta[i].email||"") + "</td>";
                /* tableBody += "<td>" + (respuesta[i].password||"") + "</td>"; */
                tableBody += "<td style='text-align: center'> <button class='btn btn-danger mb-2' onclick='adminUserDeleteAdminUser(" + (respuesta[i].idAdminUser||"") + ")'><b>Eliminar Usuario Administrativo</b></button>"
                    + " <button class='btn btn-info mb-2' onclick='verDetalle(\"" + (respuesta[i].idAdminUser||"") + "\",\"" + (respuesta[i].name||"") + "\",\"" + (respuesta[i].email||"") + "\",\"" + (respuesta[i].password||"") + "\")'><b>Ver Detalle </b></button> </td>";
                tableBody += "</tr>";
            }
            $("#t-body-adminUser").append(tableBody);
        }
    });
}

//FUNCION PARA CREAR
function adminUserPostAdminUser() {

    let myData = {
        idAdminUser: $("#idAdminUser").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val()
    }

    let errorMessage = "";

    if (!myData.idAdminUser) {
        errorMessage += " •ID "
    }
    if (!myData.name || myData.name.trim().length === 0) {
        errorMessage += " •Nombre "
    }
    if (!myData.email || myData.email.trim().length === 0) {
        errorMessage += " •Email "
    }
    if (!myData.password) {
        errorMessage += " •Contraseña "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/AdminUser/save",
        type: "POST",
        dataType: 'JSON',
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Usuario Administrativo creado correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Usuario Administrativo creado correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al crear Usuario Administrativo!");
            }
        }
    });
}

//FUNCION PARA ACTUALIZAR
function adminUserPutAdminUser() {

    let myData = {
        idAdminUser: $("#idAdminUser").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val()
    }

    let errorMessage = "";

    if (!myData.idAdminUser) {
        errorMessage += " •ID "
    }
    if (!myData.name || myData.name.trim().length === 0) {
        errorMessage += " •Nombre "
    }
    if (!myData.email || myData.email.trim().length === 0) {
        errorMessage += " •Email "
    }
    if (!myData.password) {
        errorMessage += " •Contraseña "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/AdminUser/update",
        type: "PUT",
        /* dataType: 'JSON', */
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Usuario Administrativo Actualizado Correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Usuario Administrativo Actualizado Correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al Actualizar Usuario Administrativo!");
            }
        }
    });
}


//FUNCION PARA ELIMINAR
function adminUserDeleteAdminUser(itemId) {
    let urlDelete = "http://localhost:8080/api/AdminUser/" + itemId;

    $.ajax({
        url: urlDelete,
        type: "DELETE",
        contentType: 'application/json',        
        success: function (respuesta) {
            console.log(respuesta);
            alert("Usuario Administrativo Eliminado Correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            console.log(errores);
            alert("Error al eliminar Usuario Administrativo!");
        }
    });
}

//Llenar campos a actualizar

//FUNCION PARA VER DETALLE
function verDetalle(idAdminUser, name, email, password) {

    $("#idAdminUser").val(idAdminUser);
    $("#name").val(name);
    $("#email").val(email);
    $("#password").val(password);

    $("#idAdminUser").prop('disabled', true); 
    $("#email").prop('disabled', true); 
}

//FUNCION PARA LIMPIAR CAMPOS
function limpiarCampos() {

    $("#idAdminUser").val('');
    $("#name").val('');
    $("#email").val('');
    $("#password").val('')

    $("#idAdminUser").prop('disabled', false);
    $("#email").prop('disabled', false); 
}

