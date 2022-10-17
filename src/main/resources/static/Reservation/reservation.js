//FUNCION PARA CARGAR LOS DATOS DE LA TABLA APENAS SE INICIA 
window.onload = function () {
    reservationGetReservation();
    llenarListaClientes();
    llenarListaCabañas();
}

//FUNCION PARA LLENAR LA TABLA
function reservationGetReservation() {
    $.ajax({
        url: "http://localhost:8080/api/Reservation/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {                
                tableBody += "<tr>";
                tableBody += "<td style='text-align: center'>" + respuesta[i].idReservation + "</td>";
                /* tableBody += "<td>" + (respuesta[i].startDate.slice(0,10) || "") + "</td>"; */
                /* tableBody += "<td>" + (respuesta[i].devolutionDate.slice(0,10) || "") + "</td>"; */
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].cabin||{}).name||"") + "</td>";
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].client||{}).idClient||"") + "</td>";
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].client||{}).name||"") + "</td>";
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].client||{}).email||"") + "</td>";
                /* tableBody += "<td>" + respuesta[i].status + "</td>"; */
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].score||{}).stars||"") + "</td>";                
                /* tableBody += "<td>" + respuesta[i].score.stars + " =>" + respuesta[i].score.messageText + "</td>"; */
                tableBody += "<td style='text-align: center'> <button class='btn btn-danger mb-2' onclick='reservationDeleteReservation(" + respuesta[i].idReservation + ")'><b>Eliminar Reserva</b></button>"
                    + " <button class='btn btn-info mb-2' onclick='verDetalle(\"" + respuesta[i].idReservation + "\",\"" + (respuesta[i].startDate.slice(0,10) || "") + "\",\"" + (respuesta[i].devolutionDate.slice(0,10) || "") + "\",\"" + respuesta[i].status + "\",\"" + ((respuesta[i].cabin||{}).id||"-1")
                    + "\",\"" + ((respuesta[i].client||{}).idClient||"") + "\", \"" + ((respuesta[i].score||{}).stars||"") + "\",\"" + ((respuesta[i].score||{}).messageText||"") + "\")'><b>Ver Detalle </b></button> </td>";
                tableBody += "</tr>";
            }
            $("#t-body-reservation").append(tableBody);
        }
    });
}

//FUNCION PARA CREAR
function reservationPostReservation() {

    let myData = {
        idReservation: $("#idReservation").val(),
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val(),
        status: $("#select-status").val(),
        cabin:{
            id: $("#select-cabin-id").val()
        },
        client:{
            idClient: $("#select-client-idClient").val()
        }
    }

    let errorMessage = "";

    if (!myData.idReservation) {
        errorMessage += " •ID "
    }
    if (!myData.startDate || myData.startDate.trim().length === 0) {
        errorMessage += " •Fecha de Inicio "
    }
    if (!myData.devolutionDate || myData.devolutionDate.trim().length === 0) {
        errorMessage += " •Fecha de Devolución "
    }
    if (new Date(myData.devolutionDate) < new Date(myData.startDate)) {
        errorMessage += " •Por favor validar, la fecha de entrega debe ser posterior a la fecha de inicio "
    }
    if (!myData.status || myData.status.id== "-1") {
        errorMessage += " •Estado "
    }
    if (!myData.cabin.id || myData.cabin.id== "-1") {
        errorMessage += " •Cabaña "
    }
    if (!myData.client.idClient || myData.client.idClient== "-1") {
        errorMessage += " •Cliente "
    }    
    /* if (!myData.stars) {
        errorMessage += " •Calificación, debe ser un número entre 0 y 5 "
    } */ 

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Reservation/save",
        type: "POST",
        dataType: 'JSON', 
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Reserva creada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Reserva creada correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al crear Reserva!");
            }
        }
    });
}

//FUNCION PARA ACTUALIZAR
function reservationPutReservation() {

    let myData = {
        idReservation: $("#idReservation").val(),
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val(),
        status: $("#select-status").val(),
        cabin:{
            id: $("#select-cabin-id").val()
        },
        client:{
            idClient: $("#select-client-idClient").val()
        },
        score: {
            stars: $("#score").val(),
            messageText: $("#messageText").val()
        }    
    }

    let errorMessage = "";

    if (!myData.idReservation) {
        errorMessage += " •ID "
    }
    if (!myData.startDate || myData.startDate.trim().length === 0) {
        errorMessage += " •Fecha de Inicio "
    }
    if (!myData.devolutionDate || myData.devolutionDate.trim().length === 0) {
        errorMessage += " •Fecha de Devolución "
    }
    if (new Date(myData.devolutionDate) < new Date(myData.startDate)) {
        errorMessage += " •Por favor validar, la fecha de entrega debe ser posterior a la fecha de inicio "
    }
    if (!myData.status || myData.status.id== "-1") {
        errorMessage += " •Estado "
    }    
    if (!myData.cabin.id || myData.cabin.id== "-1") {
        errorMessage += " •Cabaña "
    }
    if (!myData.client.idClient || myData.client.idClient== "-1") {
        errorMessage += " •Cliente "
    }
    if (!myData.score.stars || (myData.score.stars && (parseInt(myData.score.stars) > 5 || parseInt(myData.score.stars) < 0))) {
        errorMessage += " •Calificación, debe ser un número entre 0 y 5 "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Reservation/update",
        type: "PUT",
        /* dataType: 'JSON', */
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Reserva actualizada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Reserva actualizada correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al actualizar Reserva!");
            }
        }
    });
}

//FUNCION PARA ELIMINAR
function reservationDeleteReservation(itemId) {
    let urlDelete = "http://localhost:8080/api/Reservation/" + itemId;

    $.ajax({
        url: urlDelete,
        type: "DELETE",
        contentType: 'application/json',
        success: function (respuesta) {
            console.log(respuesta);
            alert("Reserva eliminada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            console.log(errores);
            alert("Error al eliminar la Reserva!");
        }
    });
}

//Llenar campos a actualizar

//FUNCION PARA VER DETALLE
function verDetalle(idReservation, startDate, devolutionDate, status, cabin, client, score, messageText) {

    $("#idReservation").val(idReservation);
    $("#startDate").val(startDate).change();
    $("#devolutionDate").val(devolutionDate).change();
    /* $("#status").val(status); */
    $("#select-status").val(status).change();
    $("#select-cabin-id").val(cabin).change();
    $("#select-client-idClient").val(client).change();
    $("#score").val(score);
    $("#messageText").val(messageText);

    $("#idReservation").prop('disabled', true);
    $("#select-cabin-id").prop('disabled', true);
    $("#select-client-idClient").prop('disabled', true);

}

//FUNCION PARA LIMPIAR CAMPOS
function limpiarCampos() {

    $("#idReservation").val('');
    $("#startDate").val('').change();
    $("#devolutionDate").val('').change();
    /* $("#status").val('') */
    $("#select-status").val('-1').change();
    $("#select-client-idClient").val('-1').change();
    $("#select-cabin-id").val('-1').change();
    $("#score").val('');
    $("#messageText").val('');

    $("#idReservation").prop('disabled', false);
    $("#select-cabin-id").prop('disabled', false);
    $("#select-client-idClient").prop('disabled', false);

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

function validateDate(dateStr){
    if(dateStr.length == 10){
        const splitDate = dateStr.split('-');
        return splitDate[2] + '/' + splitDate[1] + '/' + splitDate[0];
    }else{
        return "";
    }
}
                        
