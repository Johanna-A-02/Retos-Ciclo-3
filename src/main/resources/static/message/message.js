//FUNCION PARA CARGAR LOS DATOS DE LA TABLA APENAS SE INICIA 
window.onload = function () {
    messageGetMessage();
    llenarListaClientes();
    llenarListaCabañas();
}

//FUNCION PARA LLENAR LA TABLA
function messageGetMessage() {
    $.ajax({
        url: "http://localhost:8080/api/Message/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                tableBody += "<tr>";
                /* tableBody += "<td>" + respuesta[i].idMessage + "</td>"; */
                tableBody += "<td style='text-align: center'>" + respuesta[i].messageText + "</td>";
                /* tableBody += "<td>" + ((respuesta[i].client||{}).name||"") + "</td>"; */
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].cabin||{}).name||"") + "</td>";
                tableBody += "<td style='text-align: center'> <button class='btn btn-danger mb-2' onclick='messageDeleteMessage(" + respuesta[i].idMessage + ")'><b>Eliminar Mensaje</b></button>"
                    + " <button class='btn btn-info mb-2' onclick='verDetalle(\"" + respuesta[i].idMessage + "\",\"" + respuesta[i].messageText + "\",\"" + ((respuesta[i].client||{}).idClient||"") + "\",\"" + ((respuesta[i].cabin||{}).id||"") + "\")'><b>Ver Detalle </b></button> </td>";
                tableBody += "</tr>";
            }
            $("#t-body-message").append(tableBody);
        }
    });
}

//FUNCION PARA CREAR
function messagePostMessage() {
    let myData = {
        /* idMessage: $("#idMessage").val(), */
        messageText: $("#messageText").val(),
        /* client:{
            idClient: $("#select-client-idClient").val()
        }, */
        cabin:{
            id: $("#select-cabin-id").val()
        }
    }

    let errorMessage = "";

   /*  if (!myData.idMessage) {
        errorMessage += " •ID "
    } */
    if (!myData.messageText || myData.messageText.trim().length === 0) {
        errorMessage += " •Mensaje "
    }
    /* if (!myData.client.idClient || myData.client.idClient== "-1") {
        errorMessage += " •Cliente "
    } */
    if (!myData.cabin.id || myData.cabin.id== "-1") {
        errorMessage += " •Cabaña "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Message/save",
        type: "POST",
        dataType: 'JSON',
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Mensaje creado correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Mensaje creado correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al crear Mensaje!");
            }
        }
    });
}

//FUNCION PARA ACTUALIZAR
function messagePutMessage() {

    let myData = {
        idMessage: $("#idMessage").val(),
        messageText: $("#messageText").val(),
        /* client:{
            idClient: $("#select-client-idClient").val()
        }, */
        cabin:{
            id: $("#select-cabin-id").val()
        }
    }

    let errorMessage = "";

    if (!myData.idMessage) {
        errorMessage += " •ID "
    }
    if (!myData.messageText || myData.messageText.trim().length === 0) {
        errorMessage += " •Mensaje "
    }
    /* if (!myData.client.idClient || myData.client.idClient== "-1") {
        errorMessage += " •Cliente "
    } */
    if (!myData.cabin.id || myData.cabin.id== "-1") {
        errorMessage += " •Cabaña "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Message/update",
        type: "PUT",
        /*dataType: 'JSON',*/
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Mensaje actualizado correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Mensaje actualizado correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al actualizar Mensaje!");
            }
        }
    });
}


//FUNCION PARA ELIMINAR
function messageDeleteMessage(itemId) {
    let urlDelete = "http://localhost:8080/api/Message/" + itemId;

    $.ajax({
        url: urlDelete,
        type: "DELETE",
        contentType: 'application/json',
        success: function (respuesta) {
            console.log(respuesta);
            alert("Mensaje eliminado correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            console.log(errores);
            alert("Error al eliminar el Mensaje!");
        }
    });
}

//Llenar campos a actualizar

//FUNCION PARA VER DETALLE
function verDetalle(idMessage, messageText, client, cabin) {

    $("#idMessage").val(idMessage);
    $("#messageText").val(messageText);
    /* $("#select-client-idClient").val(client).change(); */
    $("#select-cabin-id").val(cabin).change();

    $("#idMessage").prop('disabled', true);
    /* $("#select-client-idClient").prop('disabled', true); */
    $("#select-cabin-id").prop('disabled', true);

}

//FUNCION PARA LIMPIAR CAMPOS
function limpiarCampos() {

    $("#idMessage").val('');
    $("#messageText").val('');
    /* $("#select-client-idClient").val('-1').change(); */
    $("#select-cabin-id").val('-1').change();

    $("#idMessage").prop('disabled', false);
    /* $("#select-client-idClient").prop('disabled', false); */
    $("#select-cabin-id").prop('disabled', false);

}

//FUNCION PARA LLENAR dropdown clientes
function llenarListaClientes() {
    $.ajax({
        url: "http://localhost:8080/api/Client/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                tableBody += "<option value='"+ respuesta[i].idClient+"'>" + respuesta[i].name + "</option>";
            }
            $("#select-client-idClient").append(tableBody);
        }
    });
}

//FUNCION PARA LLENAR dropdown cabañas
function llenarListaCabañas() {
    $.ajax({
        url: "http://localhost:8080/api/Cabin/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                tableBody += "<option value='"+ respuesta[i].id+"'>" + respuesta[i].name + "</option>";
            }
            $("#select-cabin-id").append(tableBody);
        }
    });
}