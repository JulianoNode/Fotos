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
		lengthMenu: [5, 3, 10, 20, 50],
		processing: true,
		serverSide: true,
		responsive: true,


		ajax: {
			url: '/files/datatables/server',
			data: 'data'
		},


		columns: [
		    {
		        data: null, // Passa todo o objeto da linha
		        render: function(data) {
		            return `
		                <div class="card text-center" style="width: 250px; border-radius: 10px; box-shadow: 2px 2px 10px rgba(0,0,0,0.1);">
		                    <img src="/files/image/${data.id}" class="card-img-top" loading="lazy" 
		                        style="width: 100%; height: 160px; object-fit: cover; border-radius: 10px 10px 0 0;" />
		                    <div class="card-body p-1">
		                        <small class="text-muted">ID: ${data.id}</small>										   
		                    </div>
		                    <div class="card-body p-1">
		                        <small class="text-muted">NOME: ${data.nome}</small>
		                    </div>
		                    <div class="d-flex justify-content-center mt-1">
		                        <a class="btn btn-success btn-sm mx-1" href="/files/editar/${data.id}" role="button">
		                            <i class="fas fa-edit"></i>
		                        </a>
		                        <a class="btn btn-danger btn-sm mx-1" href="/files/excluir/${data.id}" role="button" 
		                            data-toggle="modal" data-target="#confirm-modal">
		                            <i class="fas fa-times-circle"></i>
		                        </a>
		                    </div>
		                </div>
		            `;
		        }
		    },
		    { data: 'nome', visible: false } // Oculta a coluna extra de nome, já que está no card
		]
	});
});    
