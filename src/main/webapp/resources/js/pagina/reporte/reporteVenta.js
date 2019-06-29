$(document).ready(function() {

	var $local = {
		tablaGuiaRemision : "",
		$tablaGuiaRemision : $("#tablaGuiaRemision"),
		$buscar : $("#buscar"),
		$exportar : $("#exportar"),
		$estados : $("#estados"),
		$fechaInicio : $("#fechaInicio"),
		$fechaFin : $("#fechaFin")
	}

	$formGuiaRemision = $("#formGuiaRemision");
	
	$funcionUtil.crearDatePickerSimple3($local.$fechaInicio, "DD/MM/YYYY");
	$funcionUtil.crearDatePickerSimple3($local.$fechaFin, "DD/MM/YYYY");
	
	$funcionUtil.crearSelect2($local.$estados, "Seleccione estado");

	$local.tablaGuiaRemision = $local.$tablaGuiaRemision.DataTable({
		"language" : {
			"emptyTable" : "No hay resultados para la búsqueda."
		},
		"initComplete" : function() {
			$local.$tablaGuiaRemision.wrap("<div class='table-responsive'></div>");
			$tablaFuncion.aniadirFiltroDeBusquedaEnEncabezado(this, $local.$tablaGuiaRemision);
		},
		"ordering" : false,
		"columnDefs" : [ {
			"targets" : [ 0, 1, 2, 3, 4],
			"className" : "all filtrable",
			"defaultContent" : "-"
		}],
		"columns" : [ 
			{
			"data" : "dFechaPedido",
			"title" : "Fecha de pedido"
		}, {
			"data" : "sEmpresaCliente",
			"title" : "Cliente"
		}, {
			"data" : "sDescripcionProducto",
			"title" : "Descripción de producto"
		}, {
			"data" : "nCantidadProducto",
			"title" : "Cantidad de producto"
		}, {
			"data" : "sMontoTotal",
			"title" : "Monto total"
		}]
	});
	
	$local.$tablaGuiaRemision.find("thead").on('keyup', 'input.filtrable', function() {
		$local.tablaGuiaRemision.column($(this).parent().index() + ':visible').search(this.value).draw();
	});

	$local.$tablaGuiaRemision.find("thead").on('change', 'select', function() {
		var val = $.fn.dataTable.util.escapeRegex($(this).val());
		$local.tablaGuiaRemision.column($(this).parent().index() + ':visible').search(val ? '^' + val + '$' : '', true, false).draw();
	});
	
		
	$local.$buscar.on("click", function() {
		var parametro = $formGuiaRemision.serializeJSON();
		parametro.dFechaInicio = $local.$fechaInicio.data("daterangepicker").startDate.format("YYYY-MM-DD");
		parametro.dFechaFin = $local.$fechaFin.data("daterangepicker").startDate.format("YYYY-MM-DD");
		
		console.log(parametro);
		
		if ($funcionUtil.camposVacios($formGuiaRemision)) {
			$funcionUtil.notificarException($variableUtil.camposVacios, "fa-exclamation-circle", "Información", "info");
			return;
		}
		if (!$formGuiaRemision.valid()) {
			return;
		}
		
		$.ajax({
			type : "GET",
			url : $variableUtil.root + "pago/reporte?accion=buscarReporteVenta",
			data : parametro,
			beforeSend : function() {
				$local.tablaGuiaRemision.clear().draw();
				$local.$buscar.attr("disabled", true).find("i").removeClass("fa-search").addClass("fa-spinner fa-pulse fa-fw");
			},
			success : function(guias) {
				if (guias.length == 0) {
					$funcionUtil.notificarException($variableUtil.busquedaSinResultados, "fa-exclamation-circle", "Información", "info");
					return;
				}
				$local.tablaGuiaRemision.rows.add(guias).draw();
								
			},
			complete : function() {
				$local.$buscar.attr("disabled", false).find("i").removeClass("fa-spinner fa-pulse fa-fw").addClass("fa-search");
			}
		});

	});
	
	
	$local.$exportar.on("click", function() {
		var parametro = $formGuiaRemision.serializeJSON();
		parametro.dFechaInicio = $local.$fechaInicio.data("daterangepicker").startDate.format("YYYY-MM-DD");
		parametro.dFechaFin = $local.$fechaFin.data("daterangepicker").startDate.format("YYYY-MM-DD");
		
		console.log(parametro);
		
		if ($funcionUtil.camposVacios($formGuiaRemision)) {
			$funcionUtil.notificarException($variableUtil.camposVacios, "fa-exclamation-circle", "Información", "info");
			return;
		}
		if (!$formGuiaRemision.valid()) {
			return;
		}
		
		var paramReporte = $.param(parametro);
		
		window.location.href = $variableUtil.root + "pago/reporte?accion=reporteVenta&" + paramReporte;
	});

});