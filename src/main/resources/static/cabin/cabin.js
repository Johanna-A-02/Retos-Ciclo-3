//FUNCION PARA CARGAR LOS DATOS DE LA TABLA APENAS SE INICIA 
window.onload = function () {
    cabinGetCabin();
    categoryGetCategory();
}

//FUNCION PARA LLENAR LA TABLA
function cabinGetCabin() {
    $.ajax({
        url: "http://localhost:8080/api/Cabin/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                tableBody += "<tr>";
                /* tableBody += "<td>" + (respuesta[i].id||"") + "</td>"; */
                tableBody += "<td>" + (respuesta[i].name||"") + "</td>";
                tableBody += "<td>" + (respuesta[i].brand||"") + "</td>";
                tableBody += "<td>" + (respuesta[i].rooms||"") + "</td>";
                tableBody += "<td>" + (respuesta[i].description||"") + "</td>";
                tableBody += "<td>" + ((respuesta[i].category||{}).name||"") + "</td>";
                tableBody += "<td> <button class='btn btn-danger mb-2' onclick='cabinDeleteCabin(" + (respuesta[i].id||"") + ")'><b>Eliminar Cabaña</b></button>"
                    + " <button class='btn btn-info  mb-2' onclick='verDetalle(\"" 
                    + (respuesta[i].id||"") + "\",\"" + (respuesta[i].name||"") + "\",\"" + (respuesta[i].brand||"") + "\",\"" + (respuesta[i].rooms||"") + "\",\"" + (respuesta[i].description||"") + "\",\"" + ((respuesta[i].category||{}).id||"") 
                    + "\")'><b>Ver Detalle </b></button> </td>";
                tableBody += "</tr>";
            }
            $("#t-body-cabin").append(tableBody);
        }
    });
}

//FUNCION PARA CREAR
function cabinPostCabin() {
    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        brand: $("#brand").val(),
        rooms: $("#rooms").val(),
        description: $("#description").val(),
        category:{
            id: $("#select-category-id").val()
        } 
    }

    let errorMessage = "";

    if (!myData.id) {
        errorMessage += " •ID "
    }
    if (!myData.name || myData.name.trim().length === 0) {
        errorMessage += " •Nombre "
    }
    if (!myData.brand || myData.brand.trim().length === 0) {
        errorMessage += " •Marca "
    }
    if (!myData.rooms) {
        errorMessage += " •Cuartos "
    }
    if (!myData.description) {
        errorMessage += " •Descripción "
    }
    if (!myData.category.id || myData.category.id== "-1") {
        errorMessage += " •Categoría "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Cabin/save",
        type: "POST",
        dataType: 'JSON',
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Cabaña creada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Cabaña creada correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al crear Cabaña!");
            }
        }
    });
}

//FUNCION PARA ACTUALIZAR
function cabinPutCabin() {

    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        brand: $("#brand").val(),
        rooms: $("#rooms").val(),
        description: $("#description").val(),
        category:{
            id: $("#select-category-id").val()
        } 
    }

    let errorMessage = "";

    if (!myData.id) {
        errorMessage += " •ID "
    }
    if (!myData.name || myData.name.trim().length === 0) {
        errorMessage += " •Nombre "
    }
    if (!myData.brand || myData.brand.trim().length === 0) {
        errorMessage += " •Marca "
    }
    if (!myData.rooms) {
        errorMessage += " •Cuartos "
    }
    if (!myData.category.id || myData.category.id== "-1") {
        errorMessage += " •Id Categoría "
    }

    if (errorMessage.trim().length != 0) {
        alert("Error, falta rellenar los siguientes campos: " + errorMessage);
        return;
    }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Cabin/update",
        type: "PUT",
        /*dataType: 'JSON',*/
        contentType: 'application/json',
        data: dataToSend,
        success: function (respuesta) {
            console.log(respuesta);
            alert("Cabaña actualizada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            if(errores.status == 201){
                console.log(errores);
                alert("Cabaña actualizada correctamente!");
                window.location.reload();

            }else{
                console.log(errores);
                alert("Error al actualizar Cabaña!");
            }
        }
    });
}


//FUNCION PARA ELIMINAR
function cabinDeleteCabin(itemId) {
    let urlDelete = "http://localhost:8080/api/Cabin/" + itemId;

    $.ajax({
        url: urlDelete,
        type: "DELETE",
        contentType: 'application/json',
        success: function (respuesta) {
            console.log(respuesta);
            alert("Cabaña eliminada correctamente!");
            window.location.reload();
        },
        error: function (errores) {
            console.log(errores);
            alert("Error al eliminar Cabaña!");
        }
    });
}

//Llenar campos a actualizar

//FUNCION PARA VER DETALLE
function verDetalle(id, name, brand, rooms, description, category_id) {

    $("#id").val(id);
    $("#name").val(name);
    $("#brand").val(brand);
    $("#rooms").val(rooms);
    $("#description").val(description);
    $("#select-category-id").val(category_id).change();

    $("#id").prop('disabled', true);
    $("#select-category-id").prop('disabled', true);

}

//FUNCION PARA LIMPIAR CAMPOS
function limpiarCampos() {

    $("#id").val('');
    $("#name").val('');
    $("#brand").val('');
    $("#rooms").val('');
    $("#description").val('');
    $("#select-category-id").val("-1").change();

    $("#id").prop('disabled', false);
    $("#select-category-id").prop('disabled', false);

}

//FUNCION PARA LLENAR dropdown categoria
function categoryGetCategory() {
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        type: "GET",
        dataType: 'JSON',
        success: function (respuesta) {
            console.log(respuesta);

            let tableBody = "";

            for (i = 0; i < respuesta.length; i++) {
                tableBody += "<option value='"+ respuesta[i].id+"'>" + respuesta[i].name + "</option>";
            }
            $("#select-category-id").append(tableBody);
        }
    });
}


