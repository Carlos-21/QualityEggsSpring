$(document).ready(function() {

	var $local = {
		$tablaMantenimiento : $("#tablaMantenimiento"),
		tablaMantenimiento : "",
		$modalMantenimiento : $("#modalMantenimiento"),
		$aniadirMantenimento : $("#aniadirMantenimiento"),
		$registrarMantenimiento : $("#registrarMantenimiento"),
		$filaSeleccionada : "",
		$actualizarMantenimiento : $("#actualizarMantenimiento"),
		idTipoDocumento : "",
		numeroDocumento : "",
		idPedido : "",
		$clientes : $("#clientes"),
		$tiposPago : $("#tiposPago"),
		$pedidoCli : $("#pedidoCli"),
		$montoPago : $("#montoPago"),
		$horaPago: $("#horaPago"),
		$fechaPago : $("#fechaPago"),
	};

	$formMantenimiento = $("#formMantenimiento");
	
	$funcionUtil.crearSelect2($local.$clientes, "Seleccione un Cliente");
	$funcionUtil.crearSelect2($local.$tiposPago, "Seleccione un Tipo de Pago");
	$funcionUtil.crearDateTimePickerSimple($local.$horaPago, "HH:mm:ss");
	$funcionUtil.crearDatePickerSimple3($local.$fechaPago, "DD/MM/YYYY");
	
	$.fn.dataTable.ext.errMode = 'none';

	$local.$tablaMantenimiento.on('xhr.dt', function(e, settings, json, xhr) {
		switch (xhr.status) {
		case 500:
			$local.tablaMantenimiento.clear().draw();
			break;
		}
	});

	$local.tablaMantenimiento = $local.$tablaMantenimiento.DataTable({
		"ajax" : {
			"url" : $variableUtil.root + "pago/pedidoPedido?accion=buscarTodos",
			"dataSrc" : ""
		},
		"language" : {
			"emptyTable" : "No hay pagos de pedidos de clientes registrados."
		},
		"initComplete" : function() {
			$local.$tablaMantenimiento.wrap("<div class='table-responsive'></div>");
			$tablaFuncion.aniadirFiltroDeBusquedaEnEncabezado(this, $local.$tablaMantenimiento);
		},
		"columnDefs" : [ {
			"targets" : [ 0, 1, 2, 3, 4, 5, 6],
			"className" : "all filtrable",
		}, {
			"targets" : 7,
			"className" : "all dt-center",
			"defaultContent" : $variableUtil.botonActualizar + " " + $variableUtil.botonDescargar
		} ],
		"columns" : [ {
			"data" : 'nIdPago',
			"title" : "Id. Pago"
		}, {
			"data" : 'sNumeroDocumento',
			"title" : "RUC"
		},{
			"data" : 'sEmpresa',
			"title" : "Empresa"
		},{
			"data" : 'sRubro',
			"title" : "Rubro"
		},{
			"data" : 'sMonto',
			"title" : "Monto"
		}, {
			"data" : 'dFecha',
			"title" : "Fecha"
		}, {
			"data" : 'tHora',
			"title" : "Hora"
		}, {
			"data" : null,
			"title" : 'Acción'
		} ]
	});

	$local.$tablaMantenimiento.find("thead").on('keyup', 'input.filtrable', function() {
		$local.tablaMantenimiento.column($(this).parent().index() + ':visible').search(this.value).draw();
	});

	$local.$modalMantenimiento.PopupWindow({
		title : "Gestión de Pago de pedido de cliente",
		autoOpen : false,
		modal : false,
		height : 540,
		width : 610
	});

	$local.$aniadirMantenimento.on("click", function() {
		$funcionUtil.prepararFormularioRegistro2($formMantenimiento);
		$local.$actualizarMantenimiento.addClass("hidden");
		$local.$registrarMantenimiento.removeClass("hidden");
		$local.$modalMantenimiento.PopupWindow("open");
	});

	$local.$modalMantenimiento.on("open.popupwindow", function() {
		$formMantenimiento.find("input:not([disabled]):first").focus();
	});

	$local.$modalMantenimiento.on("close.popupwindow", function() {
		$local.idTipoDocumento = "";
		$local.numeroDocumento = "";
		$local.idPedido = "";
	});

	$formMantenimiento.find("input").keypress(function(event) {
		if (event.which == 13) {
			if (!$local.$registrarMantenimiento.hasClass("hidden")) {
				$local.$registrarMantenimiento.trigger("click");
				return false;
			} else {
				if (!$local.$actualizarMantenimiento.hasClass("hidden")) {
					$local.$actualizarMantenimiento.trigger("click");
				}
				return false;
			}
		}
	});

	$local.$clientes.on("change", function(event, opcionSeleccionada) {
		$local.$pedidoCli.val("");
		
		var nidPedido = $(this).val();
		
		if (nidPedido == null || nidPedido == undefined) {
			return;
		}
		
		$.ajax({
			type : "GET",
			url : $variableUtil.root + "/pedido/pedidoCliente/" + nidPedido,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("X-CSRF-TOKEN", $variableUtil.csrf);
			},
			statusCode : {
				400 : function(response) {
					$funcionUtil.limpiarMensajesDeError($formMantenimiento);
					$funcionUtil.mostrarMensajeDeError(response.responseJSON, $formMantenimiento);
				}
			},
			success : function(pedido) {
				$local.$pedidoCli.val(pedido.nCantidad + " jabas de huevo");
				$local.$montoPago.val(pedido.nMonto + " soles");
				if (opcionSeleccionada != null && opcionSeleccionada != undefined) {
					//$local.$especializaciones.val(opcionSeleccionada).trigger("change.select2");
				}
			},
			complete : function() {
				
			}
		});

	});
	
	$local.$registrarMantenimiento.on("click", function() {
		if (!$formMantenimiento.valid()) {
			return;
		}
		var pagoPedido = $formMantenimiento.serializeJSON();
		
		console.log($local.$fechaPago.data("daterangepicker").startDate.format("YYYY-MM-DD"));
		
		pagoPedido.dFecha = $local.$fechaPago.data("daterangepicker").startDate.format("YYYY-MM-DD");
		
		console.log(pagoPedido);
		
		console.log("JSON :");
		console.log(JSON.stringify(pagoPedido));
		
		var monto = $local.$montoPago.val().split(" ");
		
		if(monto.length == 2){
			pagoPedido.nMonto = monto[0];
		}
		
		$.ajax({
			type : "POST",
			url : $variableUtil.root + "pago/pedidoPedido",
			data : JSON.stringify(pagoPedido),
			beforeSend : function(xhr) {
				$local.$registrarMantenimiento.attr("disabled", true).find("i").removeClass("fa-floppy-o").addClass("fa-spinner fa-pulse fa-fw");
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.setRequestHeader("X-CSRF-TOKEN", $variableUtil.csrf);
			},
			statusCode : {
				400 : function(response) {
					$funcionUtil.limpiarMensajesDeError($formMantenimiento);
					$funcionUtil.mostrarMensajeDeError(response.responseJSON, $formMantenimiento);
				}
			},
			success : function(pagoPedido) {
				var form = $("#formMantenimiento")[0];
				var data = new FormData(form);
				
				$funcionUtil.notificarException($variableUtil.registroExitoso, "fa-check", "Aviso", "success");
				var row = $local.tablaMantenimiento.row.add(pagoPedido).draw();
				row.show().draw(false);
				$(row.node()).animateHighlight();
				
				$.ajax({
					type : "POST",
					enctype : 'multipart/form-data',
					url : $variableUtil.root + "pago/pedidoPedido/bVoucher/"+"?accion=cargar",
					data : data,
					processData : false,
					contentType : false,
					cache : false,
					beforeSend : function(xhr) {
						xhr.setRequestHeader("X-CSRF-TOKEN", $variableUtil.csrf);
					},
					success : function(response) {
						
					},
					complete : function(response) {
					}
				});
				
				$local.$modalMantenimiento.PopupWindow("close");
			},
			error : function(response) {
			},
			complete : function(response) {
				$local.$registrarMantenimiento.attr("disabled", false).find("i").addClass("fa-floppy-o").removeClass("fa-spinner fa-pulse fa-fw");
			}
		});
	});

	$local.$tablaMantenimiento.children("tbody").on("click", ".actualizar", function() {
		$funcionUtil.prepararFormularioActualizacion($formMantenimiento);
		$local.$filaSeleccionada = $(this).parents("tr");
		var pedido = $local.tablaMantenimiento.row($local.$filaSeleccionada).data();
		$local.idTipoDocumento = pedido.sTipoDocumento;
		$local.numeroDocumento = pedido.sNumeroDocumento;
		$local.idPedido = pedido.nidPedido;
		$funcionUtil.llenarFormulario(pedido, $formMantenimiento);
		$local.$clientes.trigger("change", [ pedido.nIdPedido ]);
		$local.$actualizarMantenimiento.removeClass("hidden");
		$local.$registrarMantenimiento.addClass("hidden");
		$local.$modalMantenimiento.PopupWindow("open");
	});

	$local.$actualizarMantenimiento.on("click", function() {
		if (!$formMantenimiento.valid()) {
			return;
		}
		var pedidoCliente = $formMantenimiento.serializeJSON();
		pedidoCliente.sTipoDocumentoAntiguo = $local.idTipoDocumento;
		pedidoCliente.sNumeroDocumentoAntiguo = $local.numeroDocumento;
		pedidoCliente.dFecha = $local.$fechaPedido.data("daterangepicker").startDate.format("YYYY-MM-DD");
		pedidoCliente.nidPedido = $local.idPedido;
		$.ajax({
			type : "PUT",
			url : $variableUtil.root + "pedido/pedidoCliente",
			data : JSON.stringify(pedidoCliente),
			beforeSend : function(xhr) {
				$local.$actualizarMantenimiento.attr("disabled", true).find("i").removeClass("fa-pencil-square").addClass("fa-spinner fa-pulse fa-fw");
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.setRequestHeader("X-CSRF-TOKEN", $variableUtil.csrf);
			},
			statusCode : {
				400 : function(response) {
					$funcionUtil.limpiarMensajesDeError($formMantenimiento);
					$funcionUtil.mostrarMensajeDeError(response.responseJSON, $formMantenimiento);
				}
			},
			success : function(pedidoCliente) {
				$funcionUtil.notificarException($variableUtil.actualizacionExitosa, "fa-check", "Aviso", "success");
				var row = $local.tablaMantenimiento.row($local.$filaSeleccionada).data(pedidoCliente).draw();
				row.show().draw(false);
				$(row.node()).animateHighlight();
				$local.$modalMantenimiento.PopupWindow("close");
			},
			error : function(response) {
			},
			complete : function(response) {
				$local.$actualizarMantenimiento.attr("disabled", false).find("i").addClass("fa-pencil-square").removeClass("fa-spinner fa-pulse fa-fw");
			}
		});
	});

	$local.$tablaMantenimiento.children("tbody").on("click", ".descargar", function() {
		$local.$filaSeleccionada = $(this).parents("tr");
		
		var pago = $local.tablaMantenimiento.row($local.$filaSeleccionada).data();
		console.log(pago);
		$.ajax({
			type : "GET",
			url : $variableUtil.root + "pago/pedidoPedido/voucher/" + pago.nIdPago,
			beforeSend : function(xhr) {
				$local.$registrarMantenimiento.attr("disabled", true).find("i").removeClass("fa-floppy-o").addClass("fa-spinner fa-pulse fa-fw");
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.setRequestHeader("X-CSRF-TOKEN", $variableUtil.csrf);
			},
			success : function(matricula) {
				var contentType = "application/pdf";
				var file = b64toBlob (matricula.bVoucher,contentType);
				download(file, "voucher");
			}
		});
		
	});
	
	function b64toBlob(b64Data, contentType, sliceSize) {
		  contentType = contentType || '';
		  sliceSize = sliceSize || 512;

		  var byteCharacters = atob(b64Data);
		  var byteArrays = [];

		  for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
		    var slice = byteCharacters.slice(offset, offset + sliceSize);

		    var byteNumbers = new Array(slice.length);
		    for (var i = 0; i < slice.length; i++) {
		      byteNumbers[i] = slice.charCodeAt(i);
		    }

		    var byteArray = new Uint8Array(byteNumbers);

		    byteArrays.push(byteArray);
		  }

		  var blob = new Blob(byteArrays, {type: contentType});
		  return blob;
	};
	
	function blobToFile(blob, filename){
		var file = new File([blob], filename, {type: "application/pdf", lastModified: Date.now()});
		return file;
	}
	
	function download(text, filename){
		  var blob = new Blob([text], {type: "application/pdf"});
		  var url = window.URL.createObjectURL(blob);
		  var a = document.createElement("a");
		  a.href = url;
		  a.download = filename;
		  a.click();
	};
	
});