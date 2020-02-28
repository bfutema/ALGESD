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
function handleCreateMatrizTransposted(qtdLinhas, qtdColunas) {
    let matriz = [];
    for (let i = 0; i < qtdLinhas; i++) {
        matriz[i] = [];
        for (let j = 0; j < qtdColunas; j++) {
            matriz[i][j] = parseInt(Math.random() * 20);
        }
    }

    let matriz2 = matriz.map((arr) => { return arr.slice() });

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
        for (let i = 0; i < qtdColunas; i++) {
            if (matriz2[i]) {
                let array = matriz2[i].slice();

                transposta[i] = [];

                for (let j = 0; j < qtdLinhas; j++) {
                    transposta[i][j] = array[j];
                }
            } else {
                transposta[i] = [];

                for (let j = 0; j < matriz2.length; j++) {
                    for (let k = 0; k < matriz2[j].length; k++) {
                        if (k == i) {
                            transposta[i][j] = matriz2[j][k];
                        }
                    }
                }
            }
        }
    }

    console.log('EXERCÍCIO: 7\n', '\nMatriz Normal: \n', matriz, '\nMatriz Transposta: \n', transposta);

    return { transposta, matriz2 };
};
let { transposta, matriz2 } = handleCreateMatrizTransposted(3,15);

// Exercício 8
function handleCompareMatriz(transposta, matriz2) {
    let isSimetric = false;

    if (transposta.length == matriz2.length) {
        for (let i = 0; i < transposta.length; i++) {
            if (transposta[i].length == matriz2[i].length) {
                for (let j = 0; j < transposta[0].length; j++) {
                    if (transposta[i][j] == matriz2[i][j]) {
                        isSimetric = true;
                    }
                }
            }
        }
    }

    console.log('EXERCÍCIO 8:\n', '\nÉ simétrica? ', isSimetric ? 'Sim' : 'Não');
};
handleCompareMatriz(transposta, matriz2);

// Exercício 9
function handleCheckIdentityMatriz(transposta) {
    let isIdentity = true;

    for (let i = 0; i < transposta.length; i++) {
        for (let j = 0; j < transposta[i].length; j++) {
            if (i == j && transposta[i][j] != 1) {
                isIdentity = false;
                break;
            }
            if (i != j && transposta[i][j] != 0) {
                isIdentity = false;
                break;
            }
        }
    }

    console.log('EXERCÍCIO 9: \n', '\nA matriz: ', transposta, '\nÉ identidade? ', isIdentity ? 'Sim' : 'Não');
};
let identityMatriz = [
    [1,0,0,0],
    [0,1,0,0],
    [0,0,1,0],
    [0,0,0,1]
];
let notIdentityMatriz1 = [
    [1,0,0,1],
    [0,1,0,0],
    [0,0,1,0],
    [0,0,0,1]
];
let notIdentityMatriz2 = [
    [1,0,0,0],
    [0,1,0,0],
    [0,0,1,0],
    [1,0,0,1]
];
handleCheckIdentityMatriz(transposta);
handleCheckIdentityMatriz(identityMatriz);
handleCheckIdentityMatriz(notIdentityMatriz1);
handleCheckIdentityMatriz(notIdentityMatriz2);

// Exercício 10
var rows = [];
function handleCreateTheaterRows() {
    for (let i = 0; i < 30; i++) {
        rows[i] = [];
        for (let j = 0; j < 100; j++) {
            rows[i][j] = 0;
        }
    }

    console.log('EXERCÍCIO 10: \n', '\nMatriz: ', rows);
};
handleCreateTheaterRows();
let fileira = 3, cadeira = 7;
function handleReserveOrSell(fileira, cadeira, type) {
    for (let i = 0; i < rows.length; i++) {
        for (let j = 0; j < rows[i].length; j++) {
            if (i == fileira && j == cadeira) rows[i][j] = type;
        }
    }
};
let fileira1 = 1, cadeira2 = 2;
handleReserveOrSell(fileira, cadeira, 1);
handleReserveOrSell(fileira1, cadeira2, 2);
console.log(rows);

// Exercício 11
function handleSecondDegreeEquation(a, b, c) {
    let delta = (b**2)-4*a*c;
    console.log(delta);
};
handleSecondDegreeEquation(2, 9, 6);

// Exercício 12
function handleCheckNumberCousin(n) {
    //console.log(result);
    if (n == 0.008333333333333333) {
        console.log('Não é um número inteiro!');
    }

    if (n <= 0) return 1;
    return handleCheckNumberCousin(n-1) / n;
};