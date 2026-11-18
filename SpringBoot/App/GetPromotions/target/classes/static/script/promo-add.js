$(document).ready(function () {
  const buscarOferta = document.getElementById("buscarOferta");
  const linkPromocao = document.getElementById("linkPromocao");
  $(buscarOferta).on("click", function (e) {
    e.preventDefault();
    e.stopPropagation();
    let urlString = linkPromocao.value;
    if (urlString.length > 7) {
      $.ajax({
        method: "POST",
        url: "/meta/info?url=" + urlString,
        cache: false,
        dataType: 'json',// Informa ao jQuery que a resposta será JSON
        beforeSend: function() {// limpa os campos antes da nova requisicao
          $("#alert").removeClass("alert alert-danger").text("");
          $("#titulo").val("");
          $("#site").val("");
          $("#descricao").val("")
          $("#linkImagem").attr("src", "");
          $("#loader-img").addClass("fa fa-gear fa-spin");
        },// resposta requisicao bem sucedida
        success: function (response) {
          console.log(response);
          $("#site").val(response.site);
          $("#titulo").val(response.title);
          $("#linkImagem").attr("src", response.image);
          $("#descricao").val(response.description);
        },
        // menssagem generica para estatus 5xx e outros
        error: function (xhr, status, erro) {
          console.error('Erro:', status, erro);
          $("#alert").addClass("alert alert-danger").text("Há algo errado, tente novamente ou contacte o administrador do sistema.");
          $('html, body').animate({ scrollTop: 0 }, 600);
        },
        statusCode: {// resposta para estatus 404
          404: function () {
            $("#alert").addClass("alert alert-danger").text("Nenhuma informação obtida!");
            $('html, body').animate({ scrollTop: 0 }, 600);
          }
        },
        // funcao invocada apos cada requisicao
        complete: function() {
          $("#loader-img").removeClass("fa fa-gear fa-spin");
        }
      });

    }
  });

});