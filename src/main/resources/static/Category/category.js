//FUNCION PARA CARGAR LOS DATOS DE LA TABLA APENAS SE INICIA 
window.onload = function () {
    categoryGetCategory();
}

//FUNCION PARA LLENAR LA TABLA
function categoryGetCategory() {
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                let cabinsList = "";

                if(respuesta[i].cabins && respuesta[i].cabins.length > 0){
                    for(j =0; j< respuesta[i].cabins.length; j++){
                        cabinsList += "•"+respuesta[i].cabins[j].name+"<br>";
                    }
                }

                tableBody += "<tr>";
                /* tableBody += "<td>" + respuesta[i].id + "</td>"; */
                tableBody += "<td>" + respuesta[i].name + "</td>";
                tableBody += "<td>" + respuesta[i].description + "</td>";
                tableBody += "<td>" + cabinsList + "</td>";
                tableBody += "<td style='text-align: center'> <button class='btn btn-danger mb-2' onclick='categoryDeleteCategory(" + respuesta[i].id + ")'><b>Eliminar Categoría</b></button>"
                    + " <button class='btn btn-info mb-2' onclick='verDetalle(\"" + respuesta[i].id + "\",\"" + respuesta[i].name + "\",\"" + respuesta[i].description + "\")'><b>Ver Detalle </b></button> </td>";
                tableBody += "</tr>";
            }
            $("#t-body-category").append(tableBody);
        }
    });
}

//FUNCION PARA CREAR
function categoryPostCategory() {
    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        description: $("#description").val()
    }

    let errorMessage = "";

    if (!myData.id) {
        errorMessage += " •ID "
    }
    if (!myData.name || myData.name.trim().length === 0) {
        errorMessage += " •Nombre "
    }
    if (!myData.description || myData.description.trim().length === 0) {
        errorMessage += " •Descripción "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Category/save",
        type: "POST",
        dataType: 'JSON',
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Categoría creada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Categoría creada correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al crear Categoría!");
            }
        }
    });
}

//FUNCION PARA ACTUALIZAR
function categoryPutCategory() {

    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        description: $("#description").val()
    }

    let errorMessage = "";

    if (!myData.id) {
        errorMessage += " •ID "
    }
    if (!myData.name || myData.name.trim().length === 0) {
        errorMessage += " •Nombre "
    }
    if (!myData.description || myData.description.trim().length === 0) {
        errorMessage += " •Descripción "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Category/update",
        type: "PUT",
        /*dataType: 'JSON',*/
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Categoría actualizada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Categoría actualizada correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al actualizar Categoría!");
            }
        }
    });
}

//FUNCION PARA ELIMINAR
function categoryDeleteCategory(itemId) {
    let urlDelete = "http://localhost:8080/api/Category/" + itemId;

    $.ajax({
        url: urlDelete,
        type: "DELETE",
        contentType: 'application/json',
        success: function (respuesta) {
            console.log(respuesta);
            alert("Categoría eliminada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            console.log(errores);
            alert("Error al eliminar Categoría!");
        }
    });
}

//Llenar campos a actualizar

//FUNCION PARA VER DETALLE
function verDetalle(id, name, description) {

    $("#id").val(id);
    $("#name").val(name);
    $("#description").val(description);

    $("#id").prop('disabled', true);

}

//FUNCION PARA LIMPIAR CAMPOS
function limpiarCampos() {

    $("#id").val('');
    $("#name").val('');
    $("#description").val('');

    $("#id").prop('disabled', false);

}

