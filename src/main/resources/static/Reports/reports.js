//FUNCION PARA LLENAR LA TABLA
function reportDatesGetReportDates() {

    let startDate = $("#initialDate").val();
    let devolutionDate = $("#finalDate").val();
    let errorMessage = "";

    if (!startDate || startDate.trim().length === 0) {
        errorMessage += " •Fecha de Inicio "
    }
    if (!devolutionDate || devolutionDate.trim().length === 0) {
        errorMessage += " •Fecha de Devolución "
    }
    if (new Date(devolutionDate) < new Date(startDate)) {
        errorMessage += " •Por favor validar, la fecha de entrega debe ser posterior a la fecha de inicio "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let urlReportDates = "http://localhost:8080/api/Reservation/report-dates/" + startDate + "/" + devolutionDate;
    urlReportDates = "http://localhost:8080/api/Reservation/all";

    $.ajax({
        url: urlReportDates,
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta.length);
            $("#reportDates").val(respuesta.length);
        }

    });
}

function reportStatusGetReportStatus() {
    $.ajax({
        url: "http://localhost:8080/api/Reservation/report-status",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta.completed);
            console.log(respuesta.cancelled);
            $("#completedReservation").val(respuesta.completed);
            $("#cancelledReservation").val(respuesta.cancelled);

        }

    });
}

function reportClientsGetReportClients() {
    $.ajax({
        url: "http://localhost:8080/api/Reservation/report-clients",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                tableBody += "<tr>";
                tableBody += "<td>" + ((respuesta[i].client || {}).idClient || "") + "</td>";
                tableBody += "<td>" + ((respuesta[i].client || {}).name || "") + "</td>";
                tableBody += "<td>" + ((respuesta[i].client || {}).email || "") + "</td>";
                tableBody += "<td>" + ((respuesta[i].client || {}).age || "") + "</td>";
                tableBody += "<td>" + (respuesta[i].total || "")+ "</td>";                
                tableBody += "</tr>";
            }
            $("#t-body-reports").append(tableBody);
        }
    });
}

//FUNCION PARA LIMPIAR CAMPOS
function limpiarCampos() {

    $("#initialDate").val('');
    $("#finalDate").val('');
    $("#reportDates").val('')
}

function limpiarCampos1() {

    $("#completedReservation").val('');
    $("#cancelledReservation").val('');
}

