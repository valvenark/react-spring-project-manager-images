'use client'

export interface PrimeiroComponentProps {
    mensagem: string
    mensagemDoBotao: string
}

export const PrimeiroComponent: React.FC<PrimeiroComponentProps> = (props: PrimeiroComponentProps) => {

    function hadleClick() {
        console.log('Clicou no meu primeiro componente!')
    }

    return (
        <div>
            {props.mensagem}
            {props.mensagemDoBotao}
            <button onClick={hadleClick}>Clique aqui</button>
        </div>
    )
}

export const ArrowFunction = () => {
    return (
        <h2>Arrow Function</h2>
    )
}