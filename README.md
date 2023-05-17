# recapProject

# //// TODO \\\\\\\

//Entities \\\

User : {
	UserDetails & User - 
	UserService - 
	UserManager - 
	UserDTOMapperService - 
	UserDTOMapperManager - 
	UserRepository
}
Customer : {
	User - Customer - 
	CustomerService - 
	CustomerManager - 
	CustomerDTOMapperService - 
	CustomerDTOMapperManager - 
	CustomerRepository
}
Car : Car - CarService - CarManager - CarDTOMapperService - CarDTOMapperManager - CarRepository
Model : Car - Model - ModelService - ModelManager - ModelDTOMapperService - ModelDTOMapperManager - ModelRepository
Brand : Model - Brand - BrandService - BrandManager - BrandDTOMapperService - BrandDTOMapperManager - BrandRepository
Color : Car - Color - ColorService - ColorManager - ColorDTOMapperService - ColorDTOMapperManager - ColorRepository
Rental : Customer - Rental - RentalService - RentalManager - RentalDTOMapperService - RentalDTOMapperManager - RentalRepository
Rental : Car - Rental - RentalService - RentalManager - RentalDTOMapperService - RentalDTOMapperManager - RentalRepository

//ENUMS \\\
Role : User - Role
State : Car - State
