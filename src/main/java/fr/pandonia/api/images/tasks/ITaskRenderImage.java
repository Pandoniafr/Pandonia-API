package fr.pandonia.api.images.tasks;

public interface ITaskRenderImage extends Runnable {

    /**
     * Lance la task de rendu de l'image
     */
    @Override
    void run();

}