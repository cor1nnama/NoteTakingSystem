package use_case.notes.add_tags;


public interface AddTagOutputBoundary {

    void prepareFailView(String s);

    void prepareSuccessView(AddTagOutputData addTagOutputData);
}
