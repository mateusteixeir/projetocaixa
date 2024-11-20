function validarCampos() {
    let data = document.getElementById("data").value;
    let tipo = document.getElementById("tipoMovimentacao").value;
    let numCaixa = document.getElementById("numCaixa").value;
    let descricao = document.getElementById("descricao").value;
    let valor = document.getElementById("valor").value;

    if (data === "" || tipo === "" || numCaixa === "" || descricao === "" || valor === "") {
        alert("Preencha todos os campos!");
        return false;
    }
    return true;
}

async function enviarDados() {
    let url = "http://localhost:8080/movimentacoes";
    let datamovimentacao = document.getElementById("data").value;
    let tipo = document.getElementById("tipoMovimentacao").value;
    let numCaixa = document.getElementById("numCaixa").value;
    let descricao = document.getElementById("descricao").value;
    let valor = document.getElementById("valor").value;

    try {
        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json", 
            },
            body: JSON.stringify({ data: datamovimentacao, tipo: tipo, idCaixa: numCaixa, descricao: descricao, valor: valor }), 
        });

        if (!response.ok) {
            throw new Error(`Erro ao enviar os dados: ${response.statusText}`);
        }

        const data = await response.json();
        alert("Dados enviados com sucesso!");
        console.log("Resposta do servidor:", data);

    } catch (error) {
        alert(`Ocorreu um erro: ${error.message}`);
        console.error("Erro ao enviar os dados:", error);
    }
}

document.getElementById("btn").addEventListener("click", function () {
    
    if (validarCampos()) {
        enviarDados();
    }
});
