package padroesComportamentais.iterator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class SetlistIteratorTest {
    private final String MUSICA_A = "A Hard Day's Night";
    private final String MUSICA_B = "Here Comes the Sun";
    private final String MUSICA_C = "Yesterday";
    private final String MUSICA_D = "Let It Be";

    private final ArrayList<String> TODAS_AS_MUSICAS = new ArrayList<>(
            Arrays.asList(MUSICA_A, MUSICA_B, MUSICA_C, MUSICA_D)
    );

    @Test
    void devePercorrerSetlistPrincipalCorretamente() {
        SetlistPrincipal setlistArray = new SetlistPrincipal(4);
        setlistArray.adicionarMusica(MUSICA_A);
        setlistArray.adicionarMusica(MUSICA_B);
        setlistArray.adicionarMusica(MUSICA_C);
        // Posição 3 fica null

        IIteradorDeMusicas iterator = setlistArray.criarIterador();
        ArrayList<String> musicasEncontradas = new ArrayList<>();

        while (iterator.hasNext()) {
            musicasEncontradas.add(iterator.next());
        }

        // Verifica se o Iterator pulou o item NULL (Posição 3) e o limite final
        assertEquals(3, musicasEncontradas.size(), "Deve encontrar 3 músicas, ignorando o espaço NULL no array.");
        assertTrue(musicasEncontradas.contains(MUSICA_A));
        assertFalse(musicasEncontradas.contains(MUSICA_D), "A música D não foi adicionada e não deve ser encontrada.");
    }

    @Test
    void devePercorrerSetlistEncoreCorretamente() {
        SetlistEncore setlistList = new SetlistEncore();
        setlistList.adicionarMusica(MUSICA_D);

        IIteradorDeMusicas iterator = setlistList.criarIterador();
        ArrayList<String> musicasEncontradas = new ArrayList<>();

        while (iterator.hasNext()) {
            musicasEncontradas.add(iterator.next());
        }

        // Verifica se o Iterador percorreu corretamente o ArrayList
        assertEquals(1, musicasEncontradas.size());
        assertEquals(MUSICA_D, musicasEncontradas.get(0));
    }
}