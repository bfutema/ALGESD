var vetor = [];

handleCreateVector();

// Exercício 1
function handleCreateVector() {
    for (i = 0; i < 100; i++) {
        vetor.push(i);
    }

    console.log(vetor);
}

handleLoadPairWithZero(vetor);

// Exercício 2
function handleLoadPairWithZero(vetor) {
    for (i = 0; i < vetor.length; i++) {
        if (vetor[i] % 2 == 0) {
            vetor[i] = 0;
        }
    }

    console.log(vetor);
}

