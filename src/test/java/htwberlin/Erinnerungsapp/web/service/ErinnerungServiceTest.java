package htwberlin.Erinnerungsapp.web.service;

import htwberlin.Erinnerungsapp.web.persistence.ErinnerungRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

    @ExtendWith(MockitoExtension.class)
    class ErinnerungServiceTest implements WithAssertions {

        @Mock
        private ErinnerungRepository repository;

        @InjectMocks
        private ErinnerungService underTest;

        @Test
        @DisplayName("should return true if delete was successful")

        void should_return_true_if_delete_was_successful() {
            // given
            Long givenId = 9L;
            doReturn(true).when(repository).existsById(givenId);

            // when
            boolean result = underTest.deleteById(givenId);

            // then
            verify(repository).deleteById(givenId);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("should return false if Erinnerung to delete does not exist")
        void should_return_false_if_erinnerung_to_delete_does_not_exist() {
            // given
            Long givenId = 40L;
            doReturn(false).when(repository).existsById(givenId);

            // when
            boolean result = underTest.deleteById(givenId);

            // then
            verifyNoMoreInteractions(repository);
            assertThat(result).isFalse();
    }
}
