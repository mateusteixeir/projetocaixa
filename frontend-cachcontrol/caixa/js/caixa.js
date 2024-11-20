function validarCampos() {
    let valor = document.getElementById("valor").value;
    let descricao = document.getElementById("descricao").value;

    if (valor === "" || descricao === "") {
        alert("Preencha todos os campos!");
        return false;
    }
    return true;
}

async function enviarDados() {
    let url = "http://localhost:8080/caixas";
    let saldoInicial = document.getElementById("valor").value;
    let descricao = document.getElementById("descricao").value;

    try {
        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json", 
            },
            body: JSON.stringify({ saldoInicial: saldoInicial, descricao: descricao }), 
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
