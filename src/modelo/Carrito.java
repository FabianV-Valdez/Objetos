package modelo;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDate;
public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito;
	private Entrega entrega;
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,
			List<ItemCarrito> lstItemCarrito, Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = lstItemCarrito;
		this.entrega = entrega;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public boolean isCerrado() {
		return cerrado;
	}
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	public double getDescuento() {
		return descuento;
	}
	protected void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}
	public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	@Override
	public String toString() {
		return "Carrito [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", cerrado=" + cerrado + ", descuento="
				+ descuento + ", cliente=" + cliente + ", lstItemCarrito=" + lstItemCarrito + ", entrega=" + entrega
				+ "]";
	}
	
	public double calcularTotalCarrito()
	{
		int tamanio= lstItemCarrito.size(); // Se inicializo el entero con el tama�o de la lista
		double total=0; // Se inicializo el doble 
		for (int i=0;i<tamanio;i++)
		{
			ItemCarrito item = lstItemCarrito.get(i); // Saca item i y lo guarda en un nuevo item 
			int cantidad= item.getCantidad(); // Se guarda la cantidad del item i de la lista
			Articulo itemArticulo = item.getArticulo(); // Se saca el Articulo del item i y se guarda en un nuevo articulo
			double precio = itemArticulo.getPrecio(); //Se guarda el precio unitario del Articulo
			total=total+(cantidad*precio); // Se calcula el precio total de cada item segun la cantidad del mismo
			// mientras dure el bucle el total se acumula item a item
		} // fin del bucle
		return total;  //Se retorna el total calculado
	}

	public double totalAPagarCarrito(double descuento)
	{
		// funcionamiento 
		// Se realiza el calculo de monto total del carrito y se le resta el valor del descuento
		
		int largo= lstItemCarrito.size(); //  Es el largo de la lista
		double monto=0;
		
		for (int i=0;i<largo;i++) 
		{
			ItemCarrito item = lstItemCarrito.get(i); 
			
			int cantidad= item.getCantidad(); 
			
			Articulo itemArticulo = item.getArticulo(); 
			
			double precio = itemArticulo.getPrecio(); 
			
			monto=monto+(cantidad*precio); 
		} 
		monto=monto-descuento;
		return monto;  
	}

}


   
