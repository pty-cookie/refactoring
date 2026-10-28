package fr.efrei.transfret;

import java.util.List;

public interface ExpeditionRepository {

    void sauvegarderExpedition(Expedition e);

    void mettreAJourStatut(Expedition e);

    Expedition trouverExpedition(String id);

    List<Expedition> toutesLesExpeditions();
}
