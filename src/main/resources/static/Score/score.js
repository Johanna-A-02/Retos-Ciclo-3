//FUNCION PARA CARGAR LOS DATOS DE LA TABLA APENAS SE INICIA 
window.onload = function () {
    reservationGetReservation();
    llenarListaClientes();
    llenarListaCabañas();
}

var idScoreUpdate;

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
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].cabin||{}).name||"") + "</td>";
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].client||{}).name||"") + "</td>";
                tableBody += "<td style='text-align: center'>" + (respuesta[i].status||"") + "</td>";
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].score||{}).stars||"") + "</td>";  
                tableBody += "<td style='text-align: center'>" + ((respuesta[i].score||{}).messageText||"") + "</td>";  
                tableBody += "<td style='text-align: center'> <button class='btn btn-danger mb-2' onclick='scoreDeleteScore(" + ((respuesta[i].score||{}).idScore||"")+ ")'><b>Eliminar Calificación Reserva</b></button>"
                    + " <button class='btn btn-info mb-2' onclick='verDetalle(\"" + respuesta[i].idReservation + "\",\"" + ((respuesta[i].cabin||{}).id||"") + "\",\"" 
                    + ((respuesta[i].client||{}).idClient||"") + "\",\"" + ((respuesta[i].score||{}).messageText||"") + "\",\"" + ((respuesta[i].score||{}).stars||"") + "\",\"" + ((respuesta[i].score||{}).idScore||"")+ "\")'><b>Ver Detalle </b></button> </td>";
                tableBody += "</tr>";
            }
            $("#t-body-score").append(tableBody);
        }
    });
}

//FUNCION PARA CREAR
function scorePostScore() {
    let myData = {
        messageText: $("#messageText").val(),
        stars: $("#stars").val(),
        reservation: {
            idReservation: $("#idReserva").val()
        }
    }

    let errorMessage = "";
    if (!myData.messageText || myData.messageText.trim().length === 0) {
        errorMessage += " •Mensaje ";
    }
    if (!myData.stars || (myData.stars && (parseInt(myData.stars) > 5 || parseInt(myData.stars) < 0))) {
        errorMessage += " •Calificación, debe ser un número entre 0 y 5 ";
    }
    if (!myData.reservation.idReservation) {
        errorMessage += " •Debe seleccionar una reserva, en el opción que dice ver detalle ";
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Score/save",
        type: "POST",
        dataType: 'JSON',
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Calificación creada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Calificación creada correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al crear Calificación!");
            }
        }
    });
}

//FUNCION PARA ACTUALIZAR
function scorePutScore() {

    let myData = {
        idScore: parseInt(idScoreUpdate),
        messageText: $("#messageText").val(),
        stars: $("#stars").val(),
        reservation: {
            idReservation: $("#idReserva").val()
        }
    }

    let errorMessage = "";

    if (!myData.idScore) {
        errorMessage += " •ID ";
    }
    if (!myData.messageText || myData.messageText.trim().length === 0) {
        errorMessage += " •Mensaje ";
    }
    if (!myData.stars || (myData.stars && (parseInt(myData.stars) > 5 || parseInt(myData.stars) < 0))) {
        errorMessage += " •Calificación, debe ser un número entre 0 y 5 ";
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Score/update",
        type: "PUT",
        /* dataType: 'JSON', */
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Calificación actualizada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Calificación actualizada correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al actualizar Calificación!");
            }
        }
    });
}

//FUNCION PARA ELIMINAR
function scoreDeleteScore(itemId) {
    let urlDelete = "http://localhost:8080/api/Score/" + itemId;

    $.ajax({
        url: urlDelete,
        type: "DELETE",
        contentType: 'application/json',
        success: function (respuesta) {
            console.log(respuesta);
            alert("Calificación eliminada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            console.log(errores);
            alert("Error al eliminar la Calificación!");
        }
    });
}

//Llenar campos a actualizar

//FUNCION PARA VER DETALLE
function verDetalle(idReservation, id, idClient, messageText, score, idScore) {

    $("#idReserva").val(idReservation);
    $("#select-cabin-id").val(id).change();
    $("#select-client-idClient").val(idClient).change();
    $("#messageText").val(messageText);
    $("#stars").val(score);

    idScoreUpdate = idScore;

   /*  $("#idScore").prop('disabled', true);
    $("#select-cabin-id").prop('disabled', true);
    $("#select-client-idClient").prop('disabled', true) */

}

//FUNCION PARA LIMPIAR CAMPOS
function limpiarCampos() {

    $("#idReserva").val('');
    $("#select-cabin-id").val('-1').change();
    $("#select-client-idClient").val('-1').change();
    $("#messageText").val('');
    $("#stars").val('');

    idScoreUpdate = undefined;

   /*  $("#idScore").prop('disabled', true);
    $("#select-cabin-id").prop('disabled', true);
    $("#select-client-idClient").prop('disabled', true); */

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

