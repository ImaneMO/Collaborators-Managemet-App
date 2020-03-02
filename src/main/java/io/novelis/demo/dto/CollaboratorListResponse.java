package io.novelis.demo.dto;

import java.util.Collection;

public class CollaboratorListResponse extends SuccessResponse {
	
	private final PageMeta pageMeta;
    private final Collection<CollaboratorDTO> collaborator;

    public CollaboratorListResponse(PageMeta pageMeta, Collection<CollaboratorDTO> collaborator) {
        this.collaborator = collaborator;
        this.pageMeta = pageMeta;
    }

    public PageMeta getPageMeta() {
        return pageMeta;
    }

    public Collection<CollaboratorDTO> getCollaborator() {
        return collaborator;
    }

}
