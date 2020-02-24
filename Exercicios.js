// Exercício 1
var vetor = [];

function handleCreateVector() {
    for (i = 0; i < 100; i++) {
        vetor.push(i);
    }
    console.log('EXERCÍCIO 1: ', vetor);
};
handleCreateVector();

// Exercício 2
function handleLoadPairWithZero(vetor) {
    for (i = 0; i < vetor.length; i++) {
        if (vetor[i] % 2 == 0) vetor[i] = 0;
    }
    console.log('EXERCÍCIO 2: ', vetor);
};
handleLoadPairWithZero(vetor);

// Exercício 3
var alfabeto = [];
function handleCreateAlphabetVector() {
    for (i = 0; i < 26; i++) {
        if (i == 0) alfabeto.push('A');
        if (i == 1) alfabeto.push('B');
        if (i == 2) alfabeto.push('C');
        if (i == 3) alfabeto.push('D');
        if (i == 4) alfabeto.push('E');
        if (i == 5) alfabeto.push('F');
        if (i == 6) alfabeto.push('G');
        if (i == 7) alfabeto.push('H');
        if (i == 8) alfabeto.push('I');
        if (i == 9) alfabeto.push('J');
        if (i == 10) alfabeto.push('K');
        if (i == 11) alfabeto.push('L');
        if (i == 12) alfabeto.push('M');
        if (i == 13) alfabeto.push('N');
        if (i == 14) alfabeto.push('O');
        if (i == 15) alfabeto.push('P');
        if (i == 16) alfabeto.push('Q');
        if (i == 17) alfabeto.push('R');
        if (i == 18) alfabeto.push('S');
        if (i == 19) alfabeto.push('T');
        if (i == 20) alfabeto.push('U');
        if (i == 21) alfabeto.push('V');
        if (i == 22) alfabeto.push('W');
        if (i == 23) alfabeto.push('X');
        if (i == 24) alfabeto.push('Y');
        if (i == 25) alfabeto.push('Z');
    }
    
    console.log('EXERCÍCIO 3: ', alfabeto);
};
handleCreateAlphabetVector();

// Exercício 4
function handleExchangeAlphabetVectorChars(alfabeto) {
    for (i = 0; i < alfabeto.length; i++) {
        if (i % 2 != 0) {
            var aux = alfabeto[i - 1];
            alfabeto[i - 1] = alfabeto[i];
            alfabeto[i] = aux;
        }
    }
    console.log('EXERCÍCIO 4: ', alfabeto);
};
handleExchangeAlphabetVectorChars(alfabeto);

// Exercício 5
var randomVector = [0,1,1,0,3,2,4,4,2,2,4,7,7,7,7,7];
function handleShowCapicuasOfFourElements(randomVector) {
    var capicuas = [];
    for (i = 0; i < randomVector.length; i++) {
        if (i > 0) {
            if (randomVector[i] == randomVector[i + 1]) {
                if (randomVector[i - 1] == randomVector[i + 2]) {
                    capicuas.push(
                        randomVector[i - 1] + '' +
                        randomVector[i] + '' +
                        randomVector[i + 1] + '' +
                        randomVector[i + 2]
                    );
                }
            }
        }
    }
    console.log('EXERCÍCIO 5: ', capicuas, 'Total de capicuas: ', capicuas.length);
};
handleShowCapicuasOfFourElements(randomVector);

// Exercício 6
function handleCreateMatriz() {
    var qtdLinhas = 10, qtdColunas = 10;
    var matriz = [];
    for (i = 0; i < qtdLinhas; i++) {
        matriz[i] = [];
        for (j = 0; j < qtdColunas; j++) {
            matriz[i][j] = -1;
        }
    }
    console.log('EXERCÍCIO: 6', matriz);
};
handleCreateMatriz();

// Exercício 7
function handleCreateMatrizTransposted() {
    var qtdLinhas = 10, qtdColunas = 9;
    var matriz = [];
    var matriz2 = [];
    for (let i = 0; i < qtdLinhas; i++) {
        matriz[i] = [];
        matriz2[i] = [];
        for (let j = 0; j < qtdColunas; j++) {
            matriz[i][j] = i;
            matriz2[i][j] = i;
        }
    }

    var transposta = [];
    for (let i = 0; i < matriz2.length; i++) {
        for (let j = i + 1; j < matriz2.length; j++) {
            var aux = matriz2[i][j];
            matriz2[i][j] = matriz2[j][i];
            matriz2[j][i] = aux;
        }
    }

    if (qtdLinhas > qtdColunas) {
        for (let i = 0; i < qtdColunas; i++) {
            transposta[i] = [];
            for (let j = 0; j < qtdLinhas; j++) {
                transposta[i][j] = matriz2[i][j];
            }
        }
    } else {
        for (let i = 0; i < qtdLinhas; i++) {
            transposta[i] = [];
            for (let j = 0; j < qtdColunas; j++) {
                transposta[i][j] = matriz2[i][j];
            }
        }
    }

    console.log('EXERCÍCIO: 7\n\n', 'Matriz Normal: ', matriz, 'Matriz Transposta: ', transposta);
};
handleCreateMatrizTransposted();