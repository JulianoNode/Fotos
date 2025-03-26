function previewImage(event) {
	const file = event.target.files[0];
	const imagePreview = document
		.getElementById('imagePreview');
	const imageName = document.getElementById('imageName');

	if (file) {
		const reader = new FileReader();
		reader.onload = function(e) {
			imagePreview.src = e.target.result;
			imageName.textContent = file.name;
		};
		reader.readAsDataURL(file);
	}
}

$(document).ready(function() {
	moment.locale('pt-BR');

	var table = $('#table-fileCrud').DataTable({
		"language": { "url": "//cdn.datatables.net/plug-ins/1.13.2/i18n/pt-BR.json" },
		searching: true,
		order: [[1, "asc"]],
		lengthMenu: [4, 8, 16, 20, 40],
		processing: true,
		serverSide: true,
		responsive: true,

		ajax: {
			url: '/files/datatables/server',
			data: 'data'
		},

		columns: [
			{ data: 'id' },
			{ data: 'nome' }
		],

		drawCallback: function(settings) {
			var data = this.api().rows().data(); // Obtém os dados carregados
			$('#card-container').empty(); // Limpa os cards antes de adicionar novos

			data.each(function(item) {
				$('#card-container').append(`
                    <div class="col-md-3 mb-3">
                        <div class="card text-center" style="border-radius: 10px; box-shadow: 2px 2px 10px rgba(0,0,0,0.1);">
                            <img src="/files/image/${item.id}" class="card-img-top" loading="lazy" 
                                style="width: 100%; height: 160px; object-fit: cover; border-radius: 10px 10px 0 0;" />
                            <div class="card-body p-2">
                                <small class="text-muted">ID: ${item.id}</small>										   
                            </div>
                            <div class="card-body p-1">
                                <small class="text-muted">NOME: ${item.nome}</small>
                            </div>
                            <div class="d-flex justify-content-center mt-1">
                                <a class="btn btn-success btn-sm mx-1" href="/files/editar/${item.id}" role="button" 
								data-toggle="modal"	data-target="#modalCadastroImagem"> <i class="fas fa-edit"></i> Editar
                                </a>
                                <a class="btn btn-danger btn-sm mx-1" href="/files/excluir/${item.id}" role="button" 
                                    data-toggle="modal" data-target="#confirm-modal">
                                    <i class="fas fa-times-circle"></i> Excluir
                                </a>
                            </div>
                        </div>
                    </div>
                `);
			});
		}
	});
});
