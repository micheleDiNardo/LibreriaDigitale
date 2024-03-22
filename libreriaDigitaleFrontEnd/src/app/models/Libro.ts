export interface Libro {
    titolo: string;
    autore: string;
    codiceISBN: string;
    dataAggiuntaLibreria: Date | null;
    dataEliminazione: Date | null;
    numeroLettura: number;
    trama: string;
  }