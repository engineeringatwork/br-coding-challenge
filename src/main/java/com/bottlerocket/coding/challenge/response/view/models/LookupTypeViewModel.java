package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Lookup Type View Model to capture lookup type information")
public class LookupTypeViewModel extends BaseResponseViewModel implements Serializable
{
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "Name of type", required = false)
  private String name;

  @ApiModelProperty(value = "Description of type", required = false)
  private String description;

  @ApiModelProperty(value = "Designates if a lookup type is currently active", required = false)
  private Boolean isActive;

  @ApiModelProperty(value = "List of lookup reference view models that contain the corresponding lookup options", required = false)
  private List<LookupReferenceViewModel> options = new ArrayList<LookupReferenceViewModel>();

  public LookupTypeViewModel()
  {
    super();
  }

  /**
   * @return the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name
   *        the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * @return the description
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * @param description
   *        the description to set
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  /**
   * @return the isActive
   */
  public Boolean getIsActive()
  {
    return isActive;
  }

  /**
   * @param isActive
   *        the isActive to set
   */
  public void setIsActive(Boolean isActive)
  {
    this.isActive = isActive;
  }

  /**
   * @return the options
   */
  public List<LookupReferenceViewModel> getOptions()
  {
    return options;
  }

  /**
   * @param options
   *        the options to set
   */
  public void setOptions(List<LookupReferenceViewModel> options)
  {
    this.options = options;
  }
}
